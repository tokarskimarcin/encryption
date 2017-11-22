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
    private JTextArea textArea3;
    private DataBaseController db;

    public Encryption() {
        MyActionListener myActionListener = new MyActionListener(this);
        db = new DataBaseController();

        findFileButton1.addActionListener(myActionListener);
        findFileButton2.addActionListener(myActionListener);
        findFileButton3.addActionListener(myActionListener);
        findFileButton4.addActionListener(myActionListener);
        button1.addActionListener(myActionListener);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Szyfrowanie");
        frame.setContentPane(new Encryption().mainPanel);
        frame.setSize(800,400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JButton getFindFileButton1() {
        return findFileButton1;
    }

    public void setFindFileButton1(JButton findFileButton1) {
        this.findFileButton1 = findFileButton1;
    }

    public JButton getFindFileButton2() {
        return findFileButton2;
    }

    public void setFindFileButton2(JButton findFileButton2) {
        this.findFileButton2 = findFileButton2;
    }

    public JTextField getFileTextField2() {
        return fileTextField2;
    }

    public void setFileTextField2(JTextField fileTextField2) {
        this.fileTextField2 = fileTextField2;
    }

    public JTextField getFileTextField1() {
        return fileTextField1;
    }

    public void setFileTextField1(JTextField fileTextField1) {
        this.fileTextField1 = fileTextField1;
    }

    public JButton getFindFileButton3() {
        return findFileButton3;
    }

    public void setFindFileButton3(JButton findFileButton3) {
        this.findFileButton3 = findFileButton3;
    }

    public JButton getFindFileButton4() {
        return findFileButton4;
    }

    public void setFindFileButton4(JButton findFileButton4) {
        this.findFileButton4 = findFileButton4;
    }

    public JTextField getFileTextField3() {
        return fileTextField3;
    }

    public void setFileTextField3(JTextField fileTextField3) {
        this.fileTextField3 = fileTextField3;
    }

    public JTextField getFileTextField4() {
        return fileTextField4;
    }

    public void setFileTextField4(JTextField fileTextField4) {
        this.fileTextField4 = fileTextField4;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JTextArea getTextArea2() {
        return textArea2;
    }

    public void setTextArea2(JTextArea textArea2) {
        this.textArea2 = textArea2;
    }

    public JTextArea getTextArea3() {
        return textArea3;
    }

    public void setTextArea3(JTextArea textArea3) {
        this.textArea3 = textArea3;
    }

    public DataBaseController getDb() {
        return db;
    }
}
