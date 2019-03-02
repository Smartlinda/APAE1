
public class Runme {

	public static void main(String[] args) {
		creator create = new creator();
		create.run();
		printStatus print = new printStatus();
		print.start();
		try {
			create.join();
			print.join();
		}catch (InterruptedException e) {
			e.getStackTrace();
		}
	}

}
