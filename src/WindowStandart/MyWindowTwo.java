package WindowStandart;

import javax.swing.*;
import java.awt.*;

public class MyWindowTwo extends JFrame {

        public MyWindowTwo() {
            setTitle("Test Window");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(120, 300, 500, 400);
            JButton[] jbs = new JButton[5];
            for (int i = 0; i < 5; i++) {
                jbs[i] = new JButton("#" + i);
            }
            setLayout(new BorderLayout());   // выбор компоновщика элементов
            add(jbs[0], BorderLayout.EAST); // добавление кнопки на форму
            add(jbs[1], BorderLayout.WEST);
            add(jbs[2], BorderLayout.SOUTH);
            add(jbs[3], BorderLayout.NORTH);
            add(jbs[4], BorderLayout.CENTER);
            setVisible(true);


        }

}