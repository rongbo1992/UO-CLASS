package homework;

public class Rectangle implements Measurable{
	double longs;
	double wide;
	public Rectangle (double longs, double wide){
		this.longs = longs;
		this.wide = wide;
	}
	public double getArea(){
		double area = longs * wide;
		return area;
	}
}
