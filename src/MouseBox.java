import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class MouseBox implements MouseListener {

    Configuration configuration;

    @Override
    public void mousePressed(MouseEvent e) {

        Game_Control goc;
        goc = new Game_Control();

        if (!configuration.gameOver) {
            goc.newGame();
        } else {
            // Получаем позицию клика
            int ex = e.getX() - configuration.margin;
            int ey = e.getY() - configuration.margin;

            // Нажатие на сетку
            if (ex < 0 || ex > configuration.gridSize  || ey < 0  || ey > configuration.gridSize)
                return;
            // Получаем позицию на сетке
            int c1 = ex / configuration.tileSize;
            int r1 = ey / configuration.tileSize;
            // Получаем позицию пустой ячейки
            int c2 = configuration.blankPos % configuration.size;
            int r2 = configuration.blankPos / configuration.size;
            int clickPos = r1 * configuration.size + c1;
            int dir = 0;
            // Ищем направление для перемещения ячейки
            if (c1 == c2  &&  Math.abs(r1 - r2) > 0)
                dir = (r1 - r2) > 0 ? configuration.size : -configuration.size;
            else if (r1 == r2 && Math.abs(c1 - c2) > 0)
                dir = (c1 - c2) > 0 ? 1 : -1;
            if (dir != 0) {
                //Перемещаем пустую ячейку по навралению
                do {
                    int newBlankPos = configuration.blankPos + dir;
                    configuration.tiles[configuration.blankPos] = configuration.tiles[newBlankPos];
                    configuration.blankPos = newBlankPos;
                } while(configuration.blankPos != clickPos);
                configuration.tiles[configuration.blankPos] = 0;
            }
            // Проверяем решена ли игра
            configuration.gameOver = goc.isSolved();
        }
    }
}
