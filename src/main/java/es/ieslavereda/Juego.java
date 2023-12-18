package es.ieslavereda;
import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Juego {
    private Baraja baraja;
    private Jugador[] jugadores;
    private Jugador jugadorPC;

    public Juego(Jugador[] jugadores){
        this.jugadores = jugadores;
        this.baraja = new Baraja();
        this.jugadorPC = new Jugador("BANCA");
    }
    public void start(){
        for (Jugador jugador: jugadores) {
            jugador.cartaExt(baraja.repartirEncima());
            jugador.cartaExt(baraja.repartirEncima());
        }
        jugadorPC.cartaExt(baraja.repartirEncima());
        jugadorPC.cartaExt(baraja.repartirEncima());

        //jugará cada jugador
        for(Jugador jugador:jugadores)
            juegaJugador(jugador);

        juegaPC(jugadorPC);

        mostrarGanador();

    }

    public void juegaJugador(Jugador jugador){
        System.out.println(colorize("Le toca al jugador " + jugador.getNombre(), Attribute.BLUE_TEXT()));
        System.out.println(jugador.getMano());
        String opcion = Input.getOption("¿Quieres otra carta?");

        while(opcion.equals("Y") && jugador.getPuntuacion()>=0){
            jugador.cartaExt(baraja.repartirEncima());
            System.out.println(jugador.getMano());
            if (jugador.getPuntuacion()>=0){
                opcion = Input.getOption("Otra mano? (Y/N)");
            }else{
                System.out.println(colorize("Te has pasado !!",Attribute.MAGENTA_TEXT()));
            }
        }
    }

    private int maxPuntuacionJugadores(){
        int maxPuntuacion = Integer.MIN_VALUE;
        for(Jugador jugador:jugadores){
            if(jugador.getPuntuacion()>maxPuntuacion)
                maxPuntuacion=jugador.getPuntuacion();
        }
        return maxPuntuacion;
    }

    public void juegaPC(Jugador jugador){
        System.out.println(colorize("Le toca al jugador " + jugadorPC.getNombre(), Attribute.GREEN_TEXT()));
        System.out.println(jugadorPC.getMano());
        int maxPuntuacion = maxPuntuacionJugadores();

        while(jugadorPC.getPuntuacion()>=0 && jugadorPC.getPuntuacion()<maxPuntuacion){
            esperar(2000);
            jugadorPC.cartaExt(baraja.repartirEncima());
            System.out.println(jugadorPC.getMano());
            if (jugadorPC.getPuntuacion()<0){
                System.out.println(colorize("se ha pasado la BANCA", Attribute.MAGENTA_TEXT()));
            }
        }
    }

    private void esperar(int tiempoMili){
        try{
            Thread.sleep(tiempoMili);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mostrarGanador(){
        int maxPuntuacion = maxPuntuacionJugadores();
        if (maxPuntuacion<=jugadorPC.getPuntuacion()){
            System.out.println(colorize("GANA LA BANCA!!", Attribute.RED_TEXT()));
        }else{
            int numGanadores = 0;
            String[] ganadores = new String[jugadores.length];
            for (Jugador jugador:jugadores) {
                if (jugador.getPuntuacion()==maxPuntuacion){
                    ganadores[numGanadores++] = jugador.getNombre();
                }
            }
            for (int i = 0; i < numGanadores ; i++) {
                System.out.println("GANADOR: " + ganadores[i]);
            }
        }
        String[] ganadrores = new String[jugadores.length+1];
    }
}
