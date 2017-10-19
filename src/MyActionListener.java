import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Marcin on 2017-10-15.
 */
public class MyActionListener implements ActionListener {

    private MyFrame myFrame;

    public MyActionListener(MyFrame myFrame){
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(myFrame.getButton())){
            ArrayList<JTextField> inputDataTextFieldList = myFrame.getInputDataTextFieldList();

            if(!inputDataTextFieldList.get(0).getText().isEmpty());
            if(!inputDataTextFieldList.get(1).getText().isEmpty());
            if(!inputDataTextFieldList.get(2).getText().isEmpty());
            if(!inputDataTextFieldList.get(3).getText().isEmpty());
            if(!inputDataTextFieldList.get(4).getText().isEmpty());
            if(!inputDataTextFieldList.get(5).getText().isEmpty());
        }
    }
}
