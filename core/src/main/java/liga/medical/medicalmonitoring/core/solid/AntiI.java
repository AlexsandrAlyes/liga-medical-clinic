package liga.medical.medicalmonitoring.core.solid;

public class AntiI implements Multitaskable {
    //представим что antiI это сушность которая может прыгать и летать
    @Override
    public void jump() {
    }

    @Override
    public void fly() {
    }
}

class AntiI1 implements Multitaskable {
    //представим что antiI1 это сушность которая может только прыгать,
    // приходится реализовывать метод который нам не нужен
    @Override
    public void jump() {

    }

    @Override
    public void fly() {

    }
}
