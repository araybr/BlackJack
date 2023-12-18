package es.ieslavereda;
import java.util.Arrays;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Carta[] mano;

    public Jugador (String nombre){
        this.nombre = nombre;
        this.mano = new Carta[0];
    }
    public void cartaExt(Carta carta){
        mano = Arrays.copyOf(mano, mano.length+1);
        mano[mano.length-1] = carta;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPuntuacion() {
        return getPuntuacionRecursiva(0, 0);
    }

    private int getPuntuacionRecursiva(int index, int suma) {
        if (suma > 21) return -1;
        if (index >= mano.length) return suma;

        if (mano[index].getNum().getValue().length == 1)
            return getPuntuacionRecursiva(index + 1, suma + mano[index].getNum().getValue()[0]);

        return Math.max(
                getPuntuacionRecursiva(index + 1, suma + mano[index].getNum().getValue()[0]),
                getPuntuacionRecursiva(index + 1, suma + mano[index].getNum().getValue()[1])
        );
    }

    public String getMano(){
        return  Arrays.toString(mano) + "Puntuación = " + getPuntuacion();
    }
}
