
public class Runme {

	public static void main(String[] args) {
		creator create = new creator();
		create.start();
		printStatus print = new printStatus();
		print.create = create;
		print.start();
		try {
			create.join();
			print.join();
		}catch (InterruptedException e) {
			e.getStackTrace();
		}
	}

}
