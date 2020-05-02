package WindowStandart;

import javax.lang.model.element.TypeParameterElement;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings extends JFrame {
    private static final int WIND_WIDTH = 350;
    private static final int WIND_HEIGHT = 270; // ширина / высота окна
    private GameWindow gameWindow; // ссылка на GW
    private JRadioButton jrbHumVsAi; // радиобатоны
    private JRadioButton jrHumVsHum;
    private JSlider jsFieldSize; // слайдер
    private JSlider jsWinLength;


    private static final String FIELD_SIZE_PREFIX = "Field size is ";
    private static final String WIN_LENGTH_PREFIX = "Winning length is: ";
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_WIN_LENGTH = 3;

    public Settings(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WIND_WIDTH, WIND_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds(); // класс, который символизирует прямоугольники
        int posX = (int) gameWindowBounds.getCenterX() - WIND_WIDTH / 2; // бермем широту родительского окна и чик / 2
        int posY = (int) gameWindowBounds.getCenterY() - WIND_HEIGHT / 2;
        setLocation(posX, posY); // размещаем соответственно вычислениям
        setResizable(false);
        setTitle("Creating a new game");
        setLayout(new GridLayout(10, 1));
        addGameModeControls(); //не сильно симпотично будет много строк, потому и метод
        addFieldControls();
        JButton btnStart = new JButton("Start a game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        add(btnStart);

    }

    private void addGameModeControls() {
        add(new JLabel("Choose game mode"));
        jrbHumVsAi = new JRadioButton("Humman vs. AI", true); // выбираем его выбранным
        jrHumVsHum = new JRadioButton("Human vs Human");
        ButtonGroup mode = new ButtonGroup(); // групируем наши рабиобатоны
        mode.add(jrbHumVsAi); // добавляем их в мод
        mode.add(jrHumVsHum);
        add(jrbHumVsAi);
        add(jrHumVsHum);
    }

    private void addFieldControls() {
        JLabel jlFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel jlWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE); // ползунок будет установлен изначально MIN_FIELD_SIZE
        jsWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH); //  MIN_WIN_LENGTH максимум валируется относительно размеров поля
        // добавляем слушатель
        jsFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = jsFieldSize.getValue();
                jlFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                jsWinLength.setMaximum(currentValue); // выставляем выгрышную длину
                // выставляем в текущий размер поля
            }
        });
        jsWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jlWinLength.setText(WIN_LENGTH_PREFIX + jsWinLength.getValue());
            }
        });
        add(new JLabel("Choose field size"));
        add(jlFieldSize);
        add(jsFieldSize);
        add(new JLabel("Choose winning length"));
        add(jlWinLength);
        add(jsWinLength);
    }

    private void startGame() {
        int gameMode;
        if (jrbHumVsAi.isSelected()) {
            gameMode = Map.GAME_MODE_HVA;
        } else if (jrHumVsHum.isSelected()) {
            gameMode = Map.GAME_MODE_HVH;
        } else {
            throw new RuntimeException("Hey! Unexpected game mode");
        }
        int fieldSize = jsFieldSize.getValue();
        int winLength = jsWinLength.getValue();
        gameWindow.start(gameMode, fieldSize, fieldSize, winLength);
    }

}

