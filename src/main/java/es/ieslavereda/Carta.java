package es.ieslavereda;

public class Carta {
    private int num;
    private String palo;

    public Carta(int num, String palo){
        this.num = num;
        this.palo = palo;
    }

    @Override
    public String toString() {
        return  num + palo;
    }
}
