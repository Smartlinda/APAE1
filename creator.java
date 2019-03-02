import java.util.*;

public class creator extends Thread{
	protected Station glasgow = new Station(100,3);
	protected Station edinburgh = new Station(100,5);
	protected Station london = new Station(100,10);
	protected Segment segmentGtoE = new Segment(1000,1);
	protected Segment segmentEtoL1 = new Segment(1000,1);
	protected Segment segmentEtoL2 = new Segment(1000,1);
	protected ArrayList<Track> route = new ArrayList<Track>();//all tracks are added into this
	
	//constructing a creator would create a route which includes stations and segments
	public creator() {
		route.add(glasgow);
		route.add(segmentGtoE);
		route.add(edinburgh);
		route.add(segmentEtoL1);
		route.add(segmentEtoL2);
		route.add(london);
	}
	
	public void run() {
		while(true) {
			//generate a new train, the location will be changed in the addTrain() method
			Train newTrain = new Train(new Random().nextInt(2),route.get(0));
			newTrain.create = this;
			route.get(0).addTrain(newTrain); //add train to the start of the route
			System.out.println("added");
			newTrain.start();
			System.out.println("train started");
			try {
				Thread.sleep(new Random().nextInt(8000));
			}catch(InterruptedException e) {
                e.printStackTrace();
            }
			
		}
	}
	
	/* Things to be done:  
	 * 1. I only add train to the start of the route, need to
	 * make another class or method to remove the train from
	 * the current track and add to the next track IF THE NEXT
	 * TRACK IS AVAILABLE
	 * 2. Need to make an object that continually prints out 
	 * the status of the railway
	 */
}
