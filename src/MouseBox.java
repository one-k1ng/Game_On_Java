import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class MouseBox implements MouseListener {
    @Override
    public void mousePressed(MouseEvent e) {
        if (gameOver) {
            newGame();
        } else {
            // Получаем позицию клика
            int ex = e.getX() - margin;
            int ey = e.getY() - margin;

            // Нажатие на сетку
            if (ex < 0 || ex > gridSize  || ey < 0  || ey > gridSize)
                return;
            // Получаем позицию на сетке
            int c1 = ex / tileSize;
            int r1 = ey / tileSize;
            // Получаем позицию пустой ячейки
            int c2 = blankPos % size;
            int r2 = blankPos / size;
            int clickPos = r1 * size + c1;
            int dir = 0;
            // Ищем направление для перемещения ячейки
            if (c1 == c2  &&  Math.abs(r1 - r2) > 0)
                dir = (r1 - r2) > 0 ? size : -size;
            else if (r1 == r2 && Math.abs(c1 - c2) > 0)
                dir = (c1 - c2) > 0 ? 1 : -1;
            if (dir != 0) {
                //Перемещаем пустую ячейку по навралению
                do {
                    int newBlankPos = blankPos + dir;
                    tiles[blankPos] = tiles[newBlankPos];
                    blankPos = newBlankPos;
                } while(blankPos != clickPos);
                tiles[blankPos] = 0;
            }
            // Проверяем решена ли игра
            gameOver = isSolved();
        }
        //Перересовываем панель
        repaint();
    }
}
