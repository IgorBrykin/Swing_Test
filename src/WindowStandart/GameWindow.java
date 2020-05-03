package WindowStandart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GameWindow extends JFrame {
    private static final int X_POS = 300;
    private static final int Y_POS = 400;
    private static final int WIND_WIDTH = 440;
    private static final int WIND_HEIGHT = 440;

    private Map map;
    private Settings settings;

    public GameWindow() {
        setTitle("Hello Men!!! Go, game Tic Tac Toe"); // заголовок
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
        // setLocation(X_POS,Y_POS); можно определять отдельно
        // setSize(WIND_WIDTH,WIND_HEIGHT);
        для расположения необходимо добавить add(); он наследник компонента
        соответственно мы добавляем его
        // add(btnExit); // добавятся обе, но одна ляжет на вторую  необходим менеджер размещений
        //add(btnStart); // добовляется кнопка на все окно
        // добавляем кнопки на панель, а затем в окно добавляем панель
         */

        JButton btnStart = new JButton("Start");
        JButton btnExit = new JButton("Exit");
        JPanel panelButtons = new JPanel(new GridLayout(1, 2));
        // создали панельку, GridLayout(1, 2) которая состоит из 1 колонки и 2 столбов
        // panelButtons.add(btnExit,BorderLayout.WEST);
        // panelButtons.add(btnStart, BorderLayout.EAST);
        // располложили на panelButtons по кнопке
        panelButtons.add(btnStart);
        panelButtons.add(btnExit); // АВТОМАТИЧЕСКИ ОПРЕДЕЛЯЕТСЯ, не кидается Ex
        btnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true); // вызываем окно settings
            }
        });
        map = new Map();    // создаем новую MAP

        settings = new Settings(this);  // 1. Создаем settings 2. Передаем себя сетингс мог акцентрироваться

        add(map, BorderLayout.CENTER);// добовляем ее в центр, но по дифолту она и должна быть там
        add(panelButtons, BorderLayout.SOUTH); // РАСПОЛОЖИЛИ КНОПКИ НА ЮГЕ КНОПКИ, КОТОРЫЕ ЛЕГЛИ НА BorderLayout.SOUTH
        setVisible(true);//показывает полученную форму на экране установить свойство в видимость "true"


    }

    void start(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }

}