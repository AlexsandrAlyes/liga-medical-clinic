package liga.medical.medicalmonitoring.core.solid;

public class AntiO {

    public void sendMessage(String type,String message){
        if(type.equals("email")){
            //отправка сообщения по почте;
        }
        // и тут добавляем в дальнейшим отправку смс, тем самым модифицируем а не расширяем данный класс
        if(type.equals("sms")){
            //отправка по смс;
        }
    }

}
