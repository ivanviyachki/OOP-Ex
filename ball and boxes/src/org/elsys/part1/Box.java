package org.elsys.part1;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Box extends BallContainer {
	
	double capacity;
	
	public Box(double capacity) {
		this.capacity = capacity;
	}
	
    public double getCapacity() {
        return capacity;
    }
    
	 public boolean add(Ball b) {
	        if(b != null){
	                if(b.getVolume() + getVolume() <= getCapacity()) {
	                    return balls.add(b);
	                }else throw new NotEnoughCapacityException();
	        }
	        else return false;
	    }
	 
	 public boolean addAll(Collection<Ball> balls) {
	        double maxVolume = 0;
	        for(Ball b : balls) {
	            maxVolume += b.getVolume();
	        }        
            if(maxVolume < getVolume()) {
               return balls.addAll(balls);
            }else throw new NotEnoughCapacityException();   
	    }
	
	public Iterator<Ball> getBallsFromSmallest() {
        Collections.sort(balls, (s1, s2) -> (int)(s1.getVolume()-s2.getVolume()));
        return  balls.listIterator();
    }

}