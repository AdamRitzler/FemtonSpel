import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Grid extends JFrame {
    JPanel panel1 = new JPanel();
    ArrayList<JButton> buttonsLista = new ArrayList<>();

    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button10 = new JButton("10");
    JButton button11 = new JButton("11");
    JButton button12 = new JButton("12");
    JButton button13 = new JButton("13");
    JButton button14 = new JButton("14");
    JButton button15 = new JButton("15");

    public void addButtons() {
        buttonsLista.add(button1);
        buttonsLista.add(button2);
        buttonsLista.add(button3);
        buttonsLista.add(button4);
        buttonsLista.add(button5);
        buttonsLista.add(button6);
        buttonsLista.add(button7);
        buttonsLista.add(button8);
        buttonsLista.add(button9);
        buttonsLista.add(button10);
        buttonsLista.add(button11);
        buttonsLista.add(button12);
        buttonsLista.add(button13);
        buttonsLista.add(button14);
        buttonsLista.add(button15);
    }
    public void buttonsPlacement(){
        Collections.shuffle(buttonsLista);
    }

    public void HJK() {
        addButtons();
        panel1.setLayout(new GridLayout(4, 4));
        this.setTitle("Swing Demo");
        pack();
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

        //fixa get buttons. Det här fungerar inte än
        panel1.add(buttonsLista.get(2));
        this.setLocationRelativeTo(null);

    }
}
