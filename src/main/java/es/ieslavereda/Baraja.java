package es.ieslavereda;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baraja {
    Carta[] baraja;
    private final Palo[] palos = {Palo.SPADE, Palo.HEARTS, Palo.DIAMOND, Palo.CLUB};


    public Baraja(){
        baraja = new Carta[48];
        int cant = 0;
        for (int i = 0; i < 4 ; i++) {
            for (Num num: Num.values())  {
                baraja[cant] = new Carta(num, palos[i]);
                cant++;
            }
        }
    }
    public void barajar(){
       List<Carta> listaCartas = Arrays.asList(baraja);
        Collections.shuffle(listaCartas);
        listaCartas.toArray(baraja);
    }
    public Carta repartirEncima(){
        Carta carta = null;
        if (baraja.length>0){
            carta = baraja[0];
            baraja = Arrays.copyOfRange(baraja,1,baraja.length);
        }
        return carta;
    }
    public Carta repartirDebajo(){
        Carta carta = null;
        if (baraja.length>0){
            carta = baraja[baraja.length-1];
            baraja = Arrays.copyOfRange(baraja,0,baraja.length-1);
        }
        return carta;
    }

    @Override
    public String toString() {
        return Arrays.toString(baraja);
    }

}
