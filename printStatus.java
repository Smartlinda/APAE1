
public class printStatus extends Thread{
	protected creator create;

	public void run() {
		StringBuilder sb = new StringBuilder();
		while (true) {
			sb.append("|--Glasgow-");
			for (int i = 0; i < create.route.get(0).trainsInside.size(); i++) {
				sb.append(create.route.get(0).trainsInside.get(i).trainID);
			}
			sb.append("|--Track--");
			for (int i = 0; i < create.route.get(1).trainsInside.size(); i++) {
				sb.append(create.route.get(1).trainsInside.get(i).trainID);
			}
			sb.append("|--Edinburgh-");
			for (int i = 0; i < create.route.get(2).trainsInside.size(); i++) {
				sb.append(create.route.get(2).trainsInside.get(i).trainID);
			}
			sb.append("|--Track--");
			for (int i = 0; i < create.route.get(3).trainsInside.size(); i++) {
				sb.append(create.route.get(3).trainsInside.get(i).trainID);
			}
			sb.append("|--Track--");
			for (int i = 0; i < create.route.get(4).trainsInside.size(); i++) {
				sb.append(create.route.get(4).trainsInside.get(i).trainID);
			}
			sb.append("|--London--");
			for (int i = 0; i < create.route.get(5).trainsInside.size(); i++) {
				sb.append(create.route.get(5).trainsInside.get(i).trainID);
			}
			System.out.println(sb);
			System.out.println();
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
