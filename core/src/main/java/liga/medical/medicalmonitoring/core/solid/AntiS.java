package liga.medical.medicalmonitoring.core.solid;

public class AntiS {

    public void sendMessageClient(String message, String typeMessage) {
        if (typeMessage.equals("email")) {
            //отправка сообщения
        } else {
            //Exception
        }
    }

    public void savingTheSentMessageClientInDB(){
        // сохранение в БД
    }

    public String getInfoOrder(String order){
        // Order это как будто обьект и мы получаем полную инфу;
        return order;
    }


}
