
public class Station extends Track{
	public Station(int length, int capacity) {
		super(length, capacity);
		length = 100;
	}
	
	/** Remove a train from the track, redefined because
	 * the time a train stays in a segment and station are
	 * different
	*/
	public void removeTrain(Train train) {
		lock.lock();
		try {
			Thread.sleep((length/train.getSpeed()+5)*1000);
			cond.await();
			train.setLocation(null);
		}catch(InterruptedException e) {
            e.printStackTrace();
		}
		capacity += 1;
		lock.unlock();
	}
	
}
