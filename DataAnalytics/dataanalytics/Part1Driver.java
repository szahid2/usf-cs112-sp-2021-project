package dataanalytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Part1Driver {

	public static void main(String[] args) throws IOException {
		int trainingDataPointCount = 20;
		int testDataPointCount = 20;
		ArrayList<DataPoint> trainingDataPoints = generateRandomDataPoints(trainingDataPointCount);
		ArrayList<DataPoint> testDataPoints = generateRandomDataPoints(testDataPointCount);
		writeDataPointsToFile(trainingDataPoints, "training.csv");
		writeDataPointsToFile(testDataPoints, "test.csv");
		Predictor p = new DummyPredictor();
		p.readData("test.csv");
		double accuracy = p.getAccuracy(testDataPoints);
		double precision = p.getPrecision(testDataPoints);
		
		JFrame frame = new JFrame("Predictor");
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setResizable(true);
	    frame.setLocationRelativeTo(null);
	    JPanel panel1 = new JPanel();
	    panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
	    JLabel accuracyLabel = new JLabel("Accuracy: "+ accuracy);
        panel1.add(accuracyLabel);
        panel1.add(Box.createGlue());
        JLabel precisionLabel = new JLabel("Precision: "+ precision);
        panel1.add(precisionLabel);
	    frame.add(panel1);
	}
	
	static ArrayList<DataPoint> generateRandomDataPoints(int count){
		ArrayList<DataPoint> dataPoints = new ArrayList();
		for(int x = 0; x < count;  x++) {
			String label;
			if(Math.random()>0.5) {
				label = "Good";
				
			} else {
				label = "Bad";
			}
			dataPoints.add(new DataPoint(
						Math.random()*5, 
						Math.random()*5,
						label,
						Math.random()>0.5
					));
		}
		return dataPoints;
	}
	public static void writeDataPointsToFile(ArrayList<DataPoint> dataPoints, String fileName)
			  throws IOException {
			    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			    for(DataPoint dp: dataPoints) {
			    	writer.append(""+ dp.f1+","+dp.f2+","+dp.label+","+dp.isTest+"\n");
			    }
			    writer.close();
			}

}
