import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class Track {
	// variables
	protected int length;
	protected int capacity;
	protected ArrayList<Train> trainsInside = new ArrayList<>();
//	protected Train train = new Train(new Random().nextInt(2),this,0);
	// locks and condition
	protected ReentrantLock lock = new ReentrantLock();
	protected Condition cond = lock.newCondition();

	// constructor
	public Track(int l, int c) {
		length = l;
		capacity = c;
	}

	// getter and setter
	public int getLength() {
		return length;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setLength(int l) {
		length = l;
	}

	public void setCapacity(int c) {
		capacity = c;
	}

	// Add a train to the track
	public void addTrain(Train train) {
		lock.lock();
		try {
			while (capacity == 0) { // make sure there is still capacity in the track
				train.setLocation(this);
				cond.await();
			}
			this.setCapacity(capacity - 1);
			trainsInside.add(train);
		} catch (InterruptedException e) {

		} finally {
			lock.unlock();
		}
	}

	// Remove a train from the track and add it to the next Track
	public void removeTrain(Train train) {
		lock.lock();
//		try {
//			cond.await();
			train.setLocation(null);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		this.setCapacity(capacity + 1);
		trainsInside.remove(train);
		lock.unlock();
		cond.signalAll();
	}
}
