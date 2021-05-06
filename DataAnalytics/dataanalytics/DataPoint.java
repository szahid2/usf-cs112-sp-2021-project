package dataanalytics;

public class DataPoint {
	
	double f1;
	double f2;
	String label;
	boolean isTest;
	
	public DataPoint() {
		this(0, 0, "", true);
	}
	
	public DataPoint(double f1, double f2, String label, boolean isTest) {
		this.f1= f1;
		this.f2= f2;
		this.label = label;
		this.isTest=isTest;	
	}
	
	public double getF1Double() {
		return f1;
	}
	
	public double getF2Double() {
		return f2;
	}
	
	public String getflabel() {
		return label;
	}
	
	public boolean getisTest() {
		return isTest;
	}
	
	public void setf1(double val) {
		f1 = val;
	}
	
	public void setf2(double val) {
		f2 = val;
	}
	
	public void setlabel(String val) {
		label = val;
	}
	
	public void setisTest(boolean val) {
		isTest = val;
	}
	

}
