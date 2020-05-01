package WindowStandart;

import javax.swing.*;


public class GameWindow extends JFrame {
    private static final int X_POS = 300;
    private static final int Y_POS = 400;
    private static final int WIND_WIDTH = 440;
    private static final int WIND_HEIGHT = 440;

    public GameWindow() {
        setTitle("Hello Men!!! How do you do?"); // заголовок
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /*
        операция по дефолту, это действие модет быть много мест,
        по нажатию на крестик происходит
        операция закрытия по умолчанию
        */
        setBounds(X_POS, Y_POS, WIND_WIDTH, WIND_HEIGHT);
        /*
        устанавливает координаты формы и ее размер в пикселях
        для корректного определения и для удобства лучше заводить константы,
        которые можно менять, а так же для чистоты кода
        */
        // setLocation(X_POS,Y_POS); можно определять отдельно
        // setSize(WIND_WIDTH,WIND_HEIGHT);

        JButton btnStart = new JButton("Start");
        JButton btnExit = new JButton("Exit");
        /*
        для расположения необходимо добавить add(); он наследник компонента
        соответственно мы добавляем его
         */
        add(btnStart);
        setVisible(true);
        /*
        показывает полученную форму на экране
        установить свойство в видимость "true"
        */

    }


}