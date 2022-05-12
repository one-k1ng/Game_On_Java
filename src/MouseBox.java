import java.awt.event.*;

public class MouseBox implements MouseListener {
    @Override
    public void mousePressed(MouseEvent e) {

        Game_Control goc;
        goc = new Game_Control();

        System.out.println(e.getX());

        if (Configuration.gameOver) {
            goc.newGame();
        } else {
            // Получаем позицию клика
            int ex = e.getX() - Configuration.margin;
            int ey = e.getY() - Configuration.margin;

            // Нажатие на сетку
            if (ex < 0 || ex > Configuration.gridSize || ey < 0 || ey > Configuration.gridSize)
                return;
            // Получаем позицию на сетке
            int c1 = ex / Configuration.tileSize;
            int r1 = ey / Configuration.tileSize;
            // Получаем позицию пустой ячейки
            int c2 = Configuration.blankPos % Configuration.size;
            int r2 = Configuration.blankPos / Configuration.size;
            int clickPos = r1 * Configuration.size + c1;
            int dir = 0;
            // Ищем направление для перемещения ячейки
            if (c1 == c2 && Math.abs(r1 - r2) > 0)
                dir = (r1 - r2) > 0 ? Configuration.size : -Configuration.size;
            else if (r1 == r2 && Math.abs(c1 - c2) > 0)
                dir = (c1 - c2) > 0 ? 1 : -1;
            if (dir != 0) {
                GameStats.clickCounters.set(GameStats.clickCounters.size() - 1, GameStats.clickCounters.get(GameStats.clickCounters.size() - 1) + 1);

                //Перемещаем пустую ячейку по навралению
                do {
                    int newBlankPos = Configuration.blankPos + dir;
                    Configuration.tiles[Configuration.blankPos] = Configuration.tiles[newBlankPos];
                    Configuration.blankPos = newBlankPos;
                } while (Configuration.blankPos != clickPos);
                Configuration.tiles[Configuration.blankPos] = 0;
            }
            // Проверяем решена ли игра
            Configuration.gameOver = goc.isSolved();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
