import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Marcin on 2017-10-20.
 */
public class CryptoUtils {
    public static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/NoPadding";

    public static byte[] doCrypto(Key key, byte[] inputBytes, int cipherMode) {
        Cipher cipher = null;
        byte[] outputBytes = null;

        try {

            cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, key);
            outputBytes = cipher.doFinal(inputBytes);

        } catch (NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (InvalidKeyException ex){
            ex.printStackTrace();
            System.out.print("Invalid key exception");
        }

        return outputBytes;
    }

    public static void doCryptoFiles(Key key, File inputFile, File outputFile, int cipherMode){
        FileInputStream inputStream = null;
        byte[] inputBytes = new byte[(int) inputFile.length()];
        try {
            inputStream = new FileInputStream(inputFile);
            inputStream.read(inputBytes);

            byte[] outputBytes = CryptoUtils.doCrypto(key,inputBytes, cipherMode);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
