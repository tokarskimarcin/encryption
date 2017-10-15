import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Marcin on 2017-10-12.
 */
public class MyFrame extends JFrame{

    JPanel panel;
    JLabel label1, label2;
    JPanel inputDataPanel;

    private MyActionListener myActionListener;
    private Border grayLineBorder;
    private ArrayList<JScrollPane> inputScrollPaneList;

    private ArrayList<JTextArea> inputDataTextAreaList;

    MyFrame() {
        super("Szyfrowanie");

        createComponents();
        addComponents();

        myActionListener = new MyActionListener(this);
        frameConfiguration();
    }

    /*dodawanie komponentow do widoku*/
    private void addComponents() {
        add(panel);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        panel.add(label1,c);

        c.gridx = 1;
        panel.add(label2,c);


        for(int i = 0; i< 6; i++){
            c.gridx = i%2;
            c.gridy = (i%3)+1;
            panel.add(inputScrollPaneList.get(i),c);
        }
        /*inputDataPanel.add(inputScrollPaneList.get(0),c);
        inputDataPanel.setBorder(BorderFactory.createTitledBorder(grayLineBorder,"Dane wejściowe"));*/

        panel.add(inputDataPanel,c);
    }

    /*tworzenie komponentow*/
    private void createComponents() {
        panel = new JPanel(new GridBagLayout());

        label1 = new JLabel();
        label1.setText("<html><h3>SZYFROWANIE</h3>");

        label2 = new JLabel();
        label2.setText("<html><h3>DESZYFROWANIE</h3>");

        inputDataTextAreaList = new ArrayList<>();
        inputScrollPaneList = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            inputDataTextAreaList.add(i, new JTextArea(2,30));
            inputDataTextAreaList.get(i).setLineWrap(true);
            inputDataTextAreaList.get(i).setLineWrap(true);
            inputScrollPaneList.add(i, new JScrollPane(inputDataTextAreaList.get(i)));
        }
        
        grayLineBorder = BorderFactory.createLineBorder(Color.GRAY);
        inputDataPanel = new JPanel(new GridBagLayout());
    }

    /*konfigurowanie okna aplikacji*/
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
