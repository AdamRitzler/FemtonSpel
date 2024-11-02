import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


public class Grid extends JFrame {
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    ArrayList<JButton> buttonsLista = new ArrayList<>();

    /*JButton button1 = new JButton("1");
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

     */
    JButton newGame = new JButton("New Game");
    JButton emptyButton = new JButton("");

    int emptyIndex;

    public Grid() {
        femtonSpelPanel();
    }

    public void addButtons() {
        for (int i = 1; i <= 15; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new ButtonClickListener());
            buttonsLista.add(button);
        }

        emptyButton.setVisible(false);
        buttonsLista.add(emptyButton);
        emptyIndex = 15;
    }

   /* public void addButtons() {
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

    */

    public void buttonsPlacement() {
        //randomizar arraylistan. Forloop som går igenom listan och lägger till knapparna i panelen.
        Collections.shuffle(buttonsLista);
        panel1.removeAll();

        /*for (JButton button : buttonsLista) {
            panel1.add(button);

        }*/

        for (int i = 0; i < buttonsLista.size(); i++) {
            panel1.add(buttonsLista.get(i));
            if (buttonsLista.get(i) == emptyButton) {
                emptyIndex = i;
            }
        }

        panel1.revalidate();
        panel1.repaint();

    }

    public void femtonSpelPanel() {
        panel.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(4, 4));
        panel2.setLayout(new FlowLayout());
        panel2.setPreferredSize(new Dimension(100,50));
        this.setTitle("FemtonSpel");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        add(panel);
        panel.add(panel1, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);

        panel2.add(newGame);
        newGame.addActionListener(e -> buttonsPlacement());


        addButtons();
        buttonsPlacement();

        setVisible(true);
        this.setLocationRelativeTo(null);

    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int clickedButtonIndex = buttonsLista.indexOf(clickedButton);

        }
    }
}
