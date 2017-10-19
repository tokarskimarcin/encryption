import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Marcin on 2017-10-18.
 */
public class Encryption {
    private JPanel mainPanel;
    private JLabel SZYFROWANIE;
    private JLabel DESZYFROWANIE;
    private JButton button1;
    private JButton findFileButton1;
    private JButton findFileButton2;
    private JTextField fileTextField2;
    private JTextField fileTextField1;
    private JButton findFileButton3;
    private JButton findFileButton4;
    private JTextField fileTextField3;
    private JTextField fileTextField4;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public Encryption() {
        findFileButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                String fileName = file.getAbsolutePath();
                fileTextField1.setText(fileName);
            }
        });
        findFileButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                String fileName = file.getAbsolutePath();
                fileTextField2.setText(fileName);
            }
        });
        findFileButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                String fileName = file.getAbsolutePath();
                fileTextField3.setText(fileName);
            }
        });
        findFileButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                String fileName = file.getAbsolutePath();
                fileTextField4.setText(fileName);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Szyfrowanie");
        frame.setContentPane(new Encryption().mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
