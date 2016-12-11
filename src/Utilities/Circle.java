package Utilities;

public class Circle extends GeometricObject 
{
	  private double radius;

	  /**Default constructor*/
	  public Circle() {
	    this(1.0);
	  }

	  /**Construct circle with a specified radius*/
	  public Circle(double radius) {
	    this(radius, "white", false);
	  }

	  /**Construct a circle with specified radius, filled, and color*/
	  public Circle(double radius, String color, boolean filled) {
	    super(color, filled);
	    this.radius = radius;
	  }

	  /**Return radius*/
	  public double getRadius() {
	    return radius;
	  }

	  /**Set a new radius*/
	  public void setRadius(double radius) {
	    this.radius = radius;
	  }

	  @Override
	  /**Implement the getArea method defined in GeometricObject*/
	  public double getArea() {
	    return radius*radius*Math.PI;
	  }

	  /**Implement the getPerimeter method defined in GeometricObject*/
	  public double getPerimeter() {
	    return 2*radius*Math.PI;
	  }

	  /**Override the equals() method defined in the Object class*/
	  public boolean equals(Circle circle) {
	    return this.radius == circle.getRadius();
	  }

	  @Override 
	  public String toString() {
	    return "[Circle] radius = " + radius;
	  }

	@Override
	public int compareTo(GeometricObject o) 
	{
		if (getArea() > o.getArea())
			return 1;
		else if (getArea() == o.getArea())
			return 0;
		else
			return -1;
	}

	@Override
	public void howToColor() 
	{
		System.out.println("Circle: Color around it.");
	}
}
