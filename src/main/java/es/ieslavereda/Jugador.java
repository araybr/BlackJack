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
    public int getPuntuacion(){
        Scanner sc = new Scanner(System.in);
        int puntos = 0;
        boolean preguntar;
        for (Carta carta:mano) {
            if (carta.getNum().getNum()=="A"){
                do {
                    preguntar = true;
                    System.out.println("Elije que valor ponerle al ASS: (1 0 11)");
                    int eleccion = sc.nextInt();
                    if (eleccion != 1 && eleccion!= 11){
                        preguntar = false;
                        System.out.println("Datos mal puestos");
                    }else{
                        puntos+=eleccion;
                    }
                }while(!preguntar);
            }else{
                puntos += carta.getNum().getValue()[0];
            }
        }
        if (puntos>21){
            return -1;
        }else{
            return puntos;
        }
    }
    public String getMano(){
        return  Arrays.toString(mano) + "Puntuación = " + getPuntuacion();
    }
}
