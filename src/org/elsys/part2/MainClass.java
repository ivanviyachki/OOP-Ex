package org.elsys.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.elsys.part1.Ball;
import org.elsys.part1.BallContainer;
import org.elsys.part1.Box;
import org.elsys.part1.Color;
import org.elsys.part1.NotEnoughCapacityException;


public class MainClass {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		
		List<Ball> balls = new ArrayList<Ball>();
		
		String[] fields = input.split(", ?");
			
			for(int i = 0; i < fields.length;i++) {
				
				int number = Integer.parseInt(fields[i]);
				
				switch (number % 4) {
                case 0:
                    balls.add(new Ball(1.1, Color.WHITE));
                    break;
                case 1:
                    balls.add(new Ball(2.1, Color.GREEN));
                    break;
                case 2:
                    balls.add(new Ball(3.1, Color.BLUE));
                    break;
                case 3:
                    balls.add(new Ball(4.1, Color.RED));
                    break;
				}

			}
			
			BallContainer ballContainer = new BallContainer();
			
			boolean result = ballContainer.addAll(balls);
			
		       try {
		            Box box = new Box(50);
		 
		            for (Ball ball : balls) {
		                box.add(ball);
		            }
		 
		            Iterator<Ball> ballsFromSmallestIterator = box.getBallsFromSmallest();
		 
		            Box sortedBox = new Box(50);
		 
		            while (ballsFromSmallestIterator.hasNext()) {
		                sortedBox.add(ballsFromSmallestIterator.next());
		            }
		        } catch (NotEnoughCapacityException ex) {
		            System.out.println(ex.getMessage());
		        }
			
		scanner.close();	
	}
}
