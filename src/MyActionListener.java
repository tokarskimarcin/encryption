import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Marcin on 2017-10-15.
 */
public class MyActionListener implements ActionListener {

    Encryption app;

    public MyActionListener(Encryption app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(app.getButton1())) {
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
                else {
                    String tmpText = app.getFileTextField1().getText().substring(0, app.getFileTextField1().getText().length() - 4).concat("enc.txt");
                    outputFile = new File(tmpText);
                    app.getFileTextField2().setText(tmpText);
                }

                CryptoUtils.doCryptoFiles(key, inputFile, outputFile, Cipher.ENCRYPT_MODE);
            }

            if (!app.getFileTextField2().getText().isEmpty()) {
                System.out.println("Decrypting files");
                String tmpText = app.getFileTextField2().getText();
                File inputFile = new File(tmpText);
                if (tmpText.substring(tmpText.length() - 7).equals("enc.txt"))
                    tmpText = tmpText.substring(0, tmpText.length() - 7).concat("dec.txt");
                else
                    tmpText = tmpText.concat("dec");

                File outputFile = new File(tmpText);

                CryptoUtils.doCryptoFiles(key, inputFile, outputFile, Cipher.DECRYPT_MODE);
            }

            if (!app.getTextArea1().getText().isEmpty()) {
                System.out.println("Crypting text");

                byte[] encryptedBytes = CryptoUtils.doCrypto(key, app.getTextArea1().getText().getBytes(), Cipher.ENCRYPT_MODE);

                app.getTextArea3().setText(new String(encryptedBytes));
                app.getTextArea2().setText(new String(CryptoUtils.doCrypto(key, encryptedBytes, Cipher.DECRYPT_MODE)));

            }


            if (!app.getFileTextField3().getText().isEmpty()) {
                System.out.println("Crypting binary files");
                File inputFile = new File(app.getFileTextField3().getText());
                File outputFile = new File(inputFile.getPath().substring(0, inputFile.getPath().length() - inputFile.getName().length()).concat("dec.PNG"));
                app.getFileTextField4().setText(outputFile.getPath());
                FileInputStream inputStream = null;

                byte[] inputBytes = new byte[(int) inputFile.length()];
                try {
                    inputStream = new FileInputStream(inputFile);
                    inputStream.read(inputBytes);

                    inputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                app.getDb().insert(CryptoUtils.doCrypto(key, inputBytes, Cipher.ENCRYPT_MODE), key.getEncoded());
            }

            if (!app.getFileTextField4().getText().isEmpty()) {
                System.out.println("Decrypting binary files");
                File outputFile = new File(app.getFileTextField4().getText());
                byte[][] bytes = app.getDb().getLastRow();
                Key lkey = new SecretKeySpec(bytes[0], 0, bytes[0].length, CryptoUtils.ALGORITHM);

                try {
                    FileOutputStream outputStream = new FileOutputStream(outputFile);
                    outputStream.write(CryptoUtils.doCrypto(lkey, bytes[1], Cipher.DECRYPT_MODE));
                    outputStream.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            System.out.println("End crypting.");
        }

        if (e.getSource().equals(app.getFindFileButton1())) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            app.getFileTextField1().setText(fileName);
        }

        if (e.getSource().equals(app.getFindFileButton2())) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            app.getFileTextField2().setText(fileName);
        }

        if (e.getSource().equals(app.getFindFileButton3())) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            app.getFileTextField3().setText(fileName);
        }

        if (e.getSource().equals(app.getFindFileButton4())) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            String fileName = file.getAbsolutePath();
            app.getFileTextField4().setText(fileName);
        }
    }


}