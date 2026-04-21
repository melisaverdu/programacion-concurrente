import java.util.Date;

public class MainGroupJoin {

   public static void main(String[] args) throws InterruptedException {

      Thread teapots = new Thread(new Group("Teapots")); // creo un hilo, al cual le voy a pasar una instancia runnable de un objeto de la clase Group
      Thread venThread = new Thread(new Group("VenThread"));
      Thread giA = new Thread(new Group("GiA"));

      teapots.start(); // inicio el hilo
      teapots.join(); // espero a que termine el hilo
/*
----- comentando teapots.join(); -----
En el caso en el que yo no espere a que termine el hilo, el main va a seguir corriendo.
Voy a imprimir el mensaje de teapots y de venThread intercalados, no necesariamente uno y uno.
El mensaje de GiA se va a imprimir despues de que termine el hilo venThread, pero no despues de que termine el hilo teapots,
porque no estoy esperando a que termine el hilo teapots.
*/

      venThread.start();
      venThread.join();

      giA.start();
      giA.join();

      System.out.printf("Main: se finalizo la impresion de mensajes %s\n", new Date());
   }
}