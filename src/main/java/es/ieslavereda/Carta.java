package es.ieslavereda;

import com.diogonunes.jcolor.Attribute;

public class Carta {
    private Num num;
    private Palo palo;

    public Carta(Num num, Palo palo){
        this.num = num;
        this.palo = palo;
    }

    public Num getNum() {
        return num;
    }

    @Override
    public String toString() {
        return  num + "" + palo;
    }
}
