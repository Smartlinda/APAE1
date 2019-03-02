
import java.util.*;

public class Train extends Thread {
	// variables
	protected int speed;
	protected Track location;
	protected int trainID;
	protected int nextID = 0;
	protected ArrayList<Track> route;
	protected creator create;

	// constructor
	public Train(int type, Track loc) {
		if (type == 1) { // express train
			speed = 500;
		} else if (type == 0) { // local train
			speed = 10;
		}
		location = loc;
		this.trainID = nextID;
		nextID++;
	}

	// setter and getter
	public int getSpeed() {
		return speed;
	}

	public void setType(int s) {
		if (s == 1) { // express train
			speed = 500;
		} else if (s == 0) { // local train
			speed = 10;
		}
	}

	public void setLocation(Track lo) {
		location = lo;
	}

	public Track getLocation() {
		return location;
	}

	public int getID() {
		return trainID;
	}

	public void setID(int id) {
		trainID = id;
	}

	public void run() {
		route = create.route;
		while (true) {
			// remove the train on the last track
			if (this.getLocation() == route.get(route.size() - 1)) {// if the train is at the end of the route
				route.get(route.size() - 1).removeTrain(this);
				break;
			}
			// move the trains forward
			for (int i = 0; i < route.size() - 1; i++) {
				if (this.getLocation() == route.get(i)) {
					route.get(i + 1).addTrain(this);
					route.get(i).removeTrain(this);
					break;
				}
			}
		}
	}

}
