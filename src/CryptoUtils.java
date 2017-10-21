import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Marcin on 2017-10-20.
 */
public class CryptoUtils {
    public static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void encrypt(Key key, File inputFile, File outputFile) {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }

    public static void decrypt(Key key, File inputFile, File outputFile){
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }

    public static byte[] encrypt(Key key, byte[] bytes){
        return doCrypto(Cipher.ENCRYPT_MODE, key, bytes);
    }

    public static byte[] decrypt(Key key, byte[] bytes){
        return doCrypto(Cipher.DECRYPT_MODE, key, bytes);
    }

    private static void doCrypto(int cipherMode, Key key, File inputFile,
                                 File outputFile) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, key);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            System.out.println("File inputBytes length: "+inputBytes.length);
            byte[] outputBytes = cipher.doFinal(inputBytes);

            System.out.println("File outputBytes length: "+outputBytes.length);
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException ex) {
            System.out.println("Error");
        } catch (InvalidKeyException ex){
            System.out.println("Invalid key");
        } catch (NoSuchAlgorithmException ex){
            System.out.println("No such algorithm");
        } catch (IOException ex){
            System.out.println("IOException");
        }
    }

    public static byte[] doCrypto(int cipherMode, Key key, byte[] bytes){

        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, key);

            return cipher.doFinal(bytes);

        } catch ( IllegalBlockSizeException ex) {
            System.out.println("IllegalBlockSizeException");
        } catch (InvalidKeyException ex){
            System.out.println("Invalid key");
        } catch (NoSuchAlgorithmException ex){
            System.out.println("No such algorithm");
        } catch (BadPaddingException ex){
            System.out.println("BadPaddingException");
        } catch (NoSuchPaddingException ex){
            System.out.println("NoSuchPaddingException");
        }

        return new byte[1];
    }
}
