package WindowStandart;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Hello Men!!!"); // заголовок
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// операция по дефолту
        setBounds(300, 300, 440, 440); //устанавливает координаты формы и ее размер в пикселях
        setVisible(true); // показывает полученную форму на экране
        setLayout(new BorderLayout());
    }


}