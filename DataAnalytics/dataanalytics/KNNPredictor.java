package dataanalytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class KNNPredictor extends Predictor {
	int k;
	// label1 is survived
	// label2 is not survived
	int label1Count = 0;
	int label2Count = 0;
	ArrayList<DataPoint> dataPoints = new ArrayList();

	public KNNPredictor(int k) {
		this.k = k;
	}

	@Override
	ArrayList<DataPoint> readData(String filename) throws FileNotFoundException {
		Scanner dataPointScanner = new Scanner(new File(filename));
		dataPointScanner.nextLine();
		while (dataPointScanner.hasNext()) {
			String line = dataPointScanner.nextLine();
			System.out.println(line);
			String[] values = line.split(",");
			System.out.println(values[4]);

			System.out.println(values.length);
			boolean didSurvive = Integer.parseInt(values[1]) > 0;
			boolean isTest = Math.random() > 0.1;
			if (!isTest) {
				if (didSurvive) {
					label1Count++;
				} else {
					label2Count++;
				}

			}
			double f1Value = !values[5].equals("") ? Double.parseDouble(values[5]) : 0.0;

		    double f2Value = values.length > 6 && !values[6].equals("") ? Double.parseDouble(values[6]) : 0.0;

		    DataPoint newDataPoint = new DataPoint(f1Value, f2Value,
							didSurvive ? "1" : "0", isTest);

			
			dataPoints.add(newDataPoint);
		}
		System.out.println("" + label1Count + " survived");
		System.out.println("" + label2Count + " did not survive");
		return dataPoints;
	}

	private double getDistance(DataPoint d1, DataPoint d2) {
		return Math.sqrt(Math.pow(d2.f1 - d1.f1, 2) + Math.pow(d2.f2 - d1.f2, 2));
	}

	@Override
	String test(DataPoint data) {
	    Double[][] distanceAndLabel = new Double[label1Count+label2Count][2];
	    int trainingPointCounter = 0;
		for(DataPoint d: dataPoints) {
			if(!d.isTest) {
				distanceAndLabel[trainingPointCounter][0] = getDistance(data, d);
				distanceAndLabel[trainingPointCounter][1] = d.label.equals("1")? 1.0 : 0.0;
				trainingPointCounter++;
			}
		}
		java.util.Arrays.sort(distanceAndLabel, new java.util.Comparator<Double[]>() {
		      public int compare(Double[] a, Double[] b) {
		        return a[0].compareTo(b[0]);
		      }
		    });
		int surviveCount = 0;
		int didNotSurviveCount = 0;
		for(int i = 0; i < k; i++) {
			if(distanceAndLabel[i][1] == 1.0) surviveCount++; else didNotSurviveCount++;
		}
		return surviveCount > didNotSurviveCount ? "1" : "0";
	}

	@Override
	Double getAccuracy(ArrayList<DataPoint> data) {
		double truePositive = 0;
		double falsePositive = 0;
		double falseNegative = 0;
		double trueNegative = 0;
		for(DataPoint d: data) {
			String label = test(d);
			if(label.equals("1")&& d.label.equals("1")) {
				truePositive++;
				
			} else if(label.equals("1")&& d.label.equals("0")) {
				falsePositive++;
				
			} else if(label.equals("0")&& d.label.equals("1")) {
				falseNegative++;
				
			} else if(label.equals("0")&& d.label.equals("0")) {
				trueNegative++;
				
			}
		}
		return (truePositive + trueNegative) / (truePositive + trueNegative + falsePositive + falseNegative);
	}

	@Override
	Double getPrecision(ArrayList<DataPoint> data) {
		double truePositive = 0;
		double falsePositive = 0;
		double falseNegative = 0;
		double trueNegative = 0;
		for(DataPoint d: data) {
			String label = test(d);
			if(label.equals("1")&& d.label.equals("1")) {
				truePositive++;
				
			} else if(label.equals("1")&& d.label.equals("0")) {
				falsePositive++;
				
			} else if(label.equals("0")&& d.label.equals("1")) {
				falseNegative++;
				
			} else if(label.equals("0")&& d.label.equals("0")) {
				trueNegative++;
				
			}
		}
		return truePositive  / (truePositive + falseNegative);

	}

}
