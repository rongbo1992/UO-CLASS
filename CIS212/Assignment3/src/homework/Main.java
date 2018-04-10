package homework;
import java.util.Random;
import java.util.ArrayList;

public class Main {
	private static double nextDouble(){	
	    double nextDouble = Math.random() + Double.MIN_VALUE;
	    return nextDouble;
	}
	private static double calculateSum(ArrayList<Measurable> listMeasurable) {	
		double sum = 0;
		for(int i = 0; i < listMeasurable.size(); i++){
			sum += listMeasurable.get(i).getArea();
		}
		return sum;		
	}
	public static void main(String[] args){
		ArrayList<Measurable> listMeasurable = new ArrayList<Measurable>();
		int boxArea = 0;
		int circleArea = 0;
		int rectangleArea = 0;
		int sphereArea = 0;

		for (int i = 0; i < 1000; i++){
			int number = new Random().nextInt(4);	
			if (number ==0){
				boxArea++;
				double longsNumber = nextDouble();
				double wideNumber = nextDouble();
				double highNumber = nextDouble();
				Box box = new Box(longsNumber, wideNumber, highNumber);
				listMeasurable.add(box);							
			}
			if (number ==1){
				rectangleArea++;
				double longsNumber = nextDouble();
				double wideNumber = nextDouble();
				Rectangle rectangle = new Rectangle(longsNumber, wideNumber);
				listMeasurable.add(rectangle);
			}
			if (number ==2){
				circleArea++;
				double radiusNumber = nextDouble();
				Circle circle = new Circle(radiusNumber);
				listMeasurable.add(circle);
			}
			if (number ==3){
				sphereArea++;
				double radiusNumber = nextDouble();
				Sphere sphere = new Sphere(radiusNumber);
				listMeasurable.add(sphere);
			}
			
		}
		double sum = calculateSum(listMeasurable);
		System.out.println("rects: " + rectangleArea + " boxes: " + boxArea + " circles: " + circleArea + " spheres: " + sphereArea);
        System.out.println("sum: " + sum);		
	}


}
