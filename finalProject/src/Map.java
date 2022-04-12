import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Hashtable;


public class Map {

    private static final String googleApiKey = "AIzaSyC5Y8gb3jOe7Jw2BAElFoV80uGpuFEbzbE";

    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel bodyPanel;
    private JPanel mapPanel;
    private JPanel ySliderPanel;
    private JLabel infoLabel;
    private JSlider xSlider;
    private JSlider ySlider;
    private JLabel mapLabel;

    public Map() {
        addGoogleMapImage();
        addSlidersDetails(0,300, xSlider);
        addSlidersDetails(0,600, ySlider);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Map");
        frame.setContentPane(new Map().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void addSlidersDetails(int min, int max, JSlider slider) {

        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
        labelTable.put( min, new JLabel( Integer.toString(min) ) );
        labelTable.put( max, new JLabel(Integer.toString(max) ) );
        slider.setLabelTable( labelTable );
        slider.setPaintLabels(true);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateLabel();
            }

        });
    }

    private void updateLabel() {
        String text = "x: " + xSlider.getValue() + " y:" + ySlider.getValue();
        infoLabel.setText(text);
    }

    private void addGoogleMapImage() {

    }

}
