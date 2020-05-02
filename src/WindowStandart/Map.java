package WindowStandart;

import javax.swing.*;
import java.awt.*;

/*
Игровое поле должно начинать игру с орпеделенными параметрами
 */
public class Map extends JPanel {
    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;
    Map() {
        setBackground(Color.ORANGE); // будет черной

    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("game mode: %d\nfieldSizeX: %d\nfieldSizeY: %d\nwinLength: %d",
                gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}
