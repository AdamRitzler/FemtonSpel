import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


public class Grid extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
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
    JButton emptyButton = new JButton("");
    JButton cheatButton = new JButton("Cheats");


    JButton newGame = new JButton("New Game");

    int emptyIndex;

    public Grid() {
        femtonSpelPanel();
    }


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

        emptyButton.setVisible(false);


    }

    public void cheatButtonsPlacement() {
        buttonsLista.clear();
        panel1.removeAll();
        addButtons();

        buttonsLista.add(emptyButton);
        Collections.swap(buttonsLista, 14, 15);

        for (int i = 0; i < buttonsLista.size(); i++) {
            panel1.add(buttonsLista.get(i));
            if (buttonsLista.get(i) == emptyButton) {
                emptyIndex = i;
            }
        }
        panel1.revalidate();
    }

    public void buttonsPlacement() {
        //randomizar arraylistan. Forloop som går igenom listan och lägger till knapparna i panelen.
        buttonsLista.remove(emptyButton);
        Collections.shuffle(buttonsLista);
        panel1.removeAll();
        buttonsLista.add(emptyButton);

        for (int i = 0; i < buttonsLista.size(); i++) {
            JButton button = buttonsLista.get(i);
            panel1.add(button);
            if (button == emptyButton) {
                emptyIndex = i;

            }

        }
        panel1.revalidate();
    }

    public void femtonSpelPanel() {
        panel.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(4, 4));
        panel2.setLayout(new FlowLayout());

        this.setTitle("FemtonSpel");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        add(panel);
        panel.add(panel1, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);

        panel2.add(newGame);
        panel2.add(cheatButton);

        newGame.addActionListener(this);
        cheatButton.addActionListener(this);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button14.addActionListener(this);
        button15.addActionListener(this);


        addButtons();
        buttonsPlacement();


        setVisible(true);
        this.setLocationRelativeTo(null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (e.getSource() == newGame) {
            buttonsPlacement();
            return;
        }
        if (e.getSource() == cheatButton) {
            cheatButtonsPlacement();
            return;
        }

        int clickedIndex = buttonsLista.indexOf(clickedButton);

        if (isAdjacent(clickedIndex, emptyIndex)) {
            Collections.swap(buttonsLista, clickedIndex, emptyIndex);
            emptyIndex = clickedIndex;

            panel1.removeAll();
            for (JButton button : buttonsLista) {
                panel1.add(button);
            }
            panel1.revalidate();

            if (isSolved()) {
                JOptionPane.showMessageDialog(panel, "Grattis! Du vann!");
            }
        }


    }

    private boolean isAdjacent(int index1, int index2) {
        int row1 = index1 / 4, col1 = index1 % 4;
        int row2 = index2 / 4, col2 = index2 % 4;
        return (Math.abs(row1 - row2) + Math.abs(col1 - col2)) == 1;
    }

    private boolean isSolved() {
        for (int i = 0; i < buttonsLista.size() - 1; i++) {
            String text = buttonsLista.get(i).getText();
            if (!text.equals(String.valueOf(i + 1))) return false;
        }
        return true;
    }

}
