package dataanalytics;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Part2Driver {

	
	public static void main(String[] args) throws FileNotFoundException {
		KNNPredictor predictor = new KNNPredictor(3);
		ArrayList<DataPoint> data = predictor.readData("C:\\Users\\shyer\\eclipse-workspace\\dataanalytics\\src\\dataanalytics\\titanic.csv");
		double precision = predictor.getPrecision(data);
		double accuracy = predictor.getAccuracy(data);
		System.out.println(precision);

		System.out.println(accuracy);
		
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

}
