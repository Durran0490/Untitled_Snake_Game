import javax.swing.*;
import java.awt.*;

public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(java.awt.Color.BLACK); //Задаем цвет элементов
        g.fillRect(Room.game.getWidth() * 10, 0, 10, (Room.game.getWidth() * 10) + 10);  //Рисуем прямоугольник показывающий край поля справа
        g.fillRect(0, Room.game.getHeight() * 10, (Room.game.getHeight() * 10) + 10, 10); //Рисуем прямоугольник показывающий край поля снизу

        g.fillRect(Room.game.getMouse().getX()*10, Room.game.getMouse().getY()*10, 10, 10); //Рисуем прямоугольник показывающий мышь

        java.util.List<SnakeSection> getSection = Room.game.getSnake().getSections();
        for (int i = 0; i < getSection.size(); i++) {
            g.fillRect(getSection.get(i).getX()*10, getSection.get(i).getY()*10, 10, 10); //Рисуем по очереди секции змейки
        }
    }
}
