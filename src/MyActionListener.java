import javax.crypto.KeyGenerator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Marcin on 2017-10-15.
 */
public class MyActionListener implements ActionListener {

    Encryption app;
    public MyActionListener(Encryption app){
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(app.getButton1())) {
            System.out.println("Crypting...");

            KeyGenerator keyGenerator = null;
            try {
                keyGenerator = KeyGenerator.getInstance(CryptoUtils.ALGORITHM);
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
            }
            keyGenerator.init(128);
            Key key = keyGenerator.generateKey();
            if (!app.getFileTextField1().getText().isEmpty()) {
                System.out.println("Crypting files");
                File inputFile = new File(app.getFileTextField1().getText());
                File outputFile;
                if (!app.getFileTextField2().getText().isEmpty())
                    outputFile = new File(app.getFileTextField2().getText());
                else{
                    String tmpText = app.getFileTextField1().getText().substring(0,app.getFileTextField1().getText().length()-4).concat("enc.txt");
                    outputFile = new File(tmpText);
                    app.getFileTextField2().setText(tmpText);
                }
                CryptoUtils.encrypt(key, inputFile, outputFile);
            }

            if(!app.getFileTextField2().getText().isEmpty()){
                System.out.println("Decrypting files");
                String tmpText = app.getFileTextField2().getText();
                File inputFile = new File(tmpText);
                if(tmpText.substring(tmpText.length()-7).equals("enc.txt"))
                    tmpText = tmpText.substring(0,tmpText.length()-7).concat("dec.txt");
                else
                    tmpText = tmpText.concat("dec");

                File outputFile = new File(tmpText);
                CryptoUtils.decrypt(key, inputFile, outputFile);
            }

            /*if(!app.getTextArea1().getText().isEmpty()){
                System.out.println("Crypting text");
                String inputText = app.getTextArea1().getText();
                app.setTextBytes(CryptoUtils.encrypt(key, inputText.getBytes()));
                System.out.println(new String(app.getTextBytes()));
                app.getTextArea2().setText(new String(app.getTextBytes()));
            }

            if(!app.getTextArea2().getText().isEmpty()){
                System.out.println("Decrypting text");
                String outputText = new String(CryptoUtils.decrypt(key, app.getTextBytes()));
                app.getTextArea3().setText(outputText);
            }*/

            if(!app.getTextArea1().getText().isEmpty()){
                System.out.println("Crypting text");
                app.getTextArea3().setText(CryptoUtils.encrypt(key, app.getTextArea1().getText()));
                app.getTextArea2().setText(CryptoUtils.decrypt(key));
            }


            if(!app.getFileTextField3().getText().isEmpty()){
                System.out.println("Crypting binary files");
                File inputFile = new File(app.getFileTextField3().getText());
                File outputFile = new File(inputFile.getPath().substring(0,inputFile.getPath().length()-inputFile.getName().length()).concat("enc.PNG"));
                app.getFileTextField4().setText(outputFile.getPath());
                CryptoUtils.encrypt(key, inputFile, outputFile);
            }

            if(!app.getFileTextField4().getText().isEmpty()){
                System.out.println("Decrypting binary files");
                File inputFile = new File(app.getFileTextField4().getText());
                File outputFile = new File(inputFile.getPath().substring(0,inputFile.getPath().length()-inputFile.getName().length()).concat("dec.PNG"));
                CryptoUtils.decrypt(key, inputFile, outputFile);
            }

            System.out.println("End crypting.");
        }

        if(e.getSource().equals(app.getFindFileButton1())){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            app.getFileTextField1().setText(fileName);
        }

        if (e.getSource().equals(app.getFindFileButton2())){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            app.getFileTextField2().setText(fileName);
        }

        if (e.getSource().equals(app.getFindFileButton3())){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            app.getFileTextField3().setText(fileName);
        }

        if (e.getSource().equals(app.getFindFileButton4())){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            app.getFileTextField4().setText(fileName);
        }
    }
}