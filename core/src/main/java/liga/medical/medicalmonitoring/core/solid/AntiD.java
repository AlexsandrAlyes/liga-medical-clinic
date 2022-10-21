package liga.medical.medicalmonitoring.core.solid;

public class AntiD {

    //здесь нет абстракций наши 3 класса тесно связаны;

    private final AntiD1 antiD1;
    private final AntiD2 antiD2;

    public AntiD(AntiD1 antiD1, AntiD2 antiD2) {
        this.antiD1 = antiD1;
        this.antiD2 = antiD2;
    }
}
class AntiD1{

}
class AntiD2{

}
