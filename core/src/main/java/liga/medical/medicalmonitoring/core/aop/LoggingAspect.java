package liga.medical.medicalmonitoring.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.medicalmonitoring.core.model.Debug;
import liga.medical.medicalmonitoring.core.model.Exception;
import liga.medical.medicalmonitoring.core.model.MessageDTO;
import liga.medical.medicalmonitoring.core.model.MessageStatus;
import liga.medical.medicalmonitoring.core.service.DebugService;
import liga.medical.medicalmonitoring.core.service.ExceptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final DebugService debugService;
    private final ExceptionService exceptionService;

    private final AtomicLong atomicLong = new AtomicLong(0);

    @Pointcut("@annotation(liga.medical.medicalmonitoring.core.annotations.DbLog)")
    public void loggableMethodsQueue() {
    }

    @Around("loggableMethodsQueue()")
    public Object applicationLogger(ProceedingJoinPoint joinPoint) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        String className = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();
        Object[] array = joinPoint.getArgs();

        Object argsOb = Arrays.stream(array).findFirst().get();
        MessageDTO messageDTO = null;
        if (argsOb instanceof String) {
            messageDTO = mapper.readValue(argsOb.toString(), MessageDTO.class);
        }

        System.out.println(messageDTO.toString());
        if (messageDTO.getType() == MessageStatus.ALERT || messageDTO.getType() == MessageStatus.DAILY) {
            Debug debug = new Debug();
            debug.setSystemTypeId(messageDTO.getType().toString());
            debug.setMethodParams(className + "." + methodName + "" + mapper.writeValueAsString(array));
            debug = debugService.saveDebugInDB(debug);
            log.info("id: " + debug.getId() + " system_type: " + debug.getSystemTypeId() + " param: " + debug.getMethodParams());
        } else {
            Exception exception = new Exception();
            exception.setSystemTypeId("Error");
            exception.setMethodParams(className + "." + methodName + "" + mapper.writeValueAsString(array));
            exception = exceptionService.saveExceptionInDB(exception);
            log.error("id: " + exception.getId() + " system_type: " + exception.getSystemTypeId() + " param: " + exception.getMethodParams());
        }

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }
}
