package homework;

public class Sphere extends Circle{
	public Sphere(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}
	public double getArea(){
		double area = radius * radius * Math.PI*4;
		return area;
	}
}
