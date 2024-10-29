import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JFrame {
JPanel panel1 = new JPanel();
ArrayList<JButton> buttons12 = new ArrayList<>();

  JButton button1 = new JButton("1");
    public void HJK() {
        buttons12.add(button1);
        panel1.setLayout(new GridLayout(4,4));

    }
}
