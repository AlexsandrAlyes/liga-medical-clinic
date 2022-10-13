package liga.medical.medicalmonitoring.core.model;

public enum QueueNames {
    MAIN_QUEUE("common_monitoring"),
    DAILY_QUEUE("daily_queue"),
    ALERT_QUEUE("alert_queue"),
    ERROR_QUEUE("error_queue");

    private String queueName;

    QueueNames(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueName() {
        return queueName;
    }

}