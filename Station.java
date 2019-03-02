
public class Station extends Track{
	public Station(int length, int capacity) {
		super(length, capacity);
		length = 100;
	}
	
	/** Remove a train from the track, redefined because
	 * the time a train stays in a segment and station are
	 * different
	*/
//	public void removeTrain(Train train) {
//		lock.lock();
////		try {
////			cond.await();
//			System.out.println("train " + train.trainID + "wake up");
//			train.setLocation(null);
//			this.setCapacity(capacity + 1);
//			trainsInside.remove(train);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		} finally {
//			lock.unlock();
//			cond.signalAll();
////		}
//	}
	
}
