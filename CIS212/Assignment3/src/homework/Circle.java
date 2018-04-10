package homework;

public class Circle implements Measurable {
	double radius;
	public Circle(double radius){
		this.radius = radius;
	}
	public double getArea(){
		double area = radius * radius * Math.PI;
		return area;
	}
}
