import java.io.File;

public class FileSearch implements Runnable {

	private String initPath;
	private String fileName;

	public FileSearch(String initPath, String fileName) {
		this.initPath = initPath;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		File file = new File(initPath);
		if (file.isDirectory()) {
			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
				cleanResources();
			}
		}
	}

	private void cleanResources() {

	}

	private void directoryProcess(File file) throws InterruptedException {
		File[] list = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			}
		}

		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	private void fileProcess(File file) throws InterruptedException {
		if (file.getName().equals(fileName)) {
			System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
		}

		/*
		isInterrupted() no se encuentra porque estoy implementando Runnable, no Thread. 
		
		Pero tengo acceso a Thread.interrupted() que es un método estático que devuelve el estado de interrupción del hilo actual y lo limpia. 
		Si el hilo ha sido interrumpido, devuelve true y limpia el estado de interrupción. Si no ha sido interrumpido, devuelve false. -> Que sea estático gignifica que no necesito una instancia de Thread para usarlo, puedo llamarlo directamente desde la clase Thread.


		*/
		if (Thread.interrupted()) { //si esta interrumpido, tiro una excepcion -> es decir "nose que hacer con esto, no se como manejarlo, asi que lo tiro para que lo maneje el método que me llamó"
		 	/*
			Al volver hacia atras por la excepcion, vuelvo a directoryProcess() el cual tambien no sabe que hacer con la interrupcion, 
			entonces tambien la tira hacia atras, y asi sucesivamente hasta llegar a run() que es el método que maneja la interrupcion,
			y ahi si se que hacer con ella, que es imprimir un mensaje y limpiar recursos.
			*/
			throw new InterruptedException(); //
		}
	}
}
