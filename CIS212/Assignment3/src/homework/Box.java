package homework;

public class Box implements Measurable {
	double longs;
	double wide;
	double high;
	public Box (double longs, double wide, double high){
		this.longs = longs;
		this.wide = wide;
		this.high = high;
	}
	public double getArea(){
		double area = (2*longs*wide) + (2*longs*high)+ (2*wide*high);
		return area;
	}

}
