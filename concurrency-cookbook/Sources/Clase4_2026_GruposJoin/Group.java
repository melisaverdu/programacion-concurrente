public class Group implements Runnable {

   private String message;

   public Group(String message) {
      this.message = String.format("Hola, somos el grupo %s y este es nuestro mensaje numero: ", message);
   }

   @Override
   public void run() {
      for (int i=1; i<100; i++) {
         String msj = String.format("%s %d", message, i);
         System.out.println(msj);
      }
   }
}
