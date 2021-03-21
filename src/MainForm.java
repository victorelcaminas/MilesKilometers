import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainForm extends JFrame {

    public static final float KMS_IN_A_MILE = 1.60934f;

    private JTextField textFieldMiles;
    private JButton convertToKmButton;
    private JTextField textFieldKilometers;
    private JButton convertToMilesButton;
    private JPanel mainPanel;

    public MainForm(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        convertToKmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textFieldMiles.getText();
                float miles = 0;
                try {
                    miles = Float.parseFloat(text);
                } catch (NumberFormatException ex) {
                    // Do nothing. It will be 0
                }
                float kms = convertMilesToKms(miles);
                String kmsStr = String.format("%.4f", kms);
                textFieldKilometers.setText(kmsStr);
            }
        });
        convertToMilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textFieldKilometers.getText();
                float kms = 0;
                try {
                    kms = Float.parseFloat(text);
                } catch (NumberFormatException ex) {
                    // Do nothing. It will be 0
                }
                float miles = convertKmsToMiles(kms);
                String milesStr = String.format("%.4f", miles);
                textFieldMiles.setText(milesStr);
            }
        });
    }

    public float convertMilesToKms(float miles) {
        return  miles * KMS_IN_A_MILE;
    }

    public float convertKmsToMiles(float kms) {
        return  kms / KMS_IN_A_MILE;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainForm("Converter");
                frame.setVisible(true);
            }
        });

    }
}
