
public class Segment extends Track {
	public Segment(int length, int capacity) {
		super(length, capacity);
		length = 1000;
		capacity = 1;
	}

	/**
	 * Remove a train from the track, redefined because the time a train stays in a
	 * segment and station are different
	 */

//	public void removeTrain(Train train) {
//		lock.lock();
//		try {
////			cond.await();
//			train.sleep((length / train.getSpeed()) * 1000);
//			train.setLocation(null);
//			this.setCapacity(capacity + 1);
//			trainsInside.remove(train);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			lock.unlock();
//			cond.signalAll();
//		}
//	}
}
