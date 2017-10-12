import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcin on 2017-10-12.
 */
public class MyFrame extends JFrame {

    public MyFrame() {
        super("Szyfrowanie");

        frameConfiguration();
    }

    private void frameConfiguration() {
        setLayout(new FlowLayout());
        setSize(800, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
