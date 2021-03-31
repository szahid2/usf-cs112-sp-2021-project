package dataanalytics;

import java.util.ArrayList;
import java.util.Scanner;

public class DummyPredictor extends Predictor {



	@Override
	ArrayList<DataPoint> readData(String filename) {
//		Scanner dataPointScanner = new Scanner(filename);
//		ArrayList<DataPoint> dataPoints = new ArrayList();
//		while(dataPointScanner.hasNext()) {
//			String line = dataPointScanner.nextLine();
//			String[] values = line.split(",");
//			DataPoint newDataPoint = new DataPoint(
//						Double.parseDouble(values[0]),
//						Double.parseDouble(values[1]),
//						values[2],
//						Boolean.parseBoolean(values[3])
//					);
//			dataPoints.add(newDataPoint);
//		}
		ArrayList<DataPoint> dataPoints = new ArrayList();
		dataPoints.add(new DataPoint(0.1, 0.7, "test", false));
		return dataPoints;
	}

	@Override
	String test(DataPoint data) {
		
		return "test";
	}

	@Override
	Double getAccuracy(ArrayList<DataPoint> data) {
		
		return Math.random();
	}

	@Override
	Double getPrecision(ArrayList<DataPoint> data) {
		// TODO Auto-generated method stub
		return Math.random();
	}

}
