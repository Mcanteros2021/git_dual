import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private Integer numPartida;
    private Integer puntuacion;
    private HashMap<Integer, Ball> balls;
    private String usuario;
    private static Integer contPartida = 1;

    public Game(String usuario) {
        this.numPartida = contPartida;
        this.puntuacion = puntuacion;
        this.usuario = usuario;
        this.balls = new HashMap<>();
        contPartida++;

    }
    Scanner sc = new Scanner(System.in);

    public boolean launchAndStart(){

        Integer numBall = 0;
        Boolean ok = false;


        do{


            String partida = "";

            System.out.println("Introduzca el tipo de partida que quiere jugar:");
            System.out.println("Rapida ( 3 bolas ) / Normal ( 5 bolas ) / escriba NO para salir");
            partida = sc.nextLine();


            if(partida.equals("rapida")){

                numBall = 3;
                ok = true;

            } else if (partida.equals("normal")) {

                numBall = 5;
                ok = true;
            } else if (partida.equals("NO")) {

                ok = true;

            }


        } while (ok != true);

        if(numBall != 0){

            Integer puntuacionFinal = 0;

            for (int i = 0; i < numBall; i++) {


                Ball bola = new Ball();
                balls.put(i, juegoBall(bola,i));
                puntuacionFinal = puntuacionFinal + bola.getPuntuacion();
                System.out.println("La puntuación de la bola "+ i +" es de "+ bola.getPuntuacion());
                System.out.println("Y ha rebotado "+ bola.getBounce()+ " veces ");

            }



            puntuacion = puntuacionFinal;
            System.out.println("La puntuación final es de "+ puntuacionFinal);

        } else {

            return false;

        }

        return true;


    }

    private Ball juegoBall(Ball ball, int num){


        int bounces =  (int) Math.round(Math.random() * 10);
        Integer puntuacion = 0;

        System.out.println("Bola número " + num );
        System.out.println("Escriba cualquier cosa para jugar la siguiente bola");
        sc.next();


        for (int i = 0; i < bounces; i++) {

            int numRandom = (int) Math.round( Math.random() * 1000);
            puntuacion =+ numRandom;

           }

        ball.setPuntuacion(puntuacion);
        ball.setBounce(bounces);

            return ball;

        }




    }



