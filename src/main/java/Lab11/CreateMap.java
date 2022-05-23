package Lab11;

import java.io.IOException;
import java.util.*;

public class CreateMap {
    private final int MAP_WIDTH;
    private final int MAP_HEIGHT;
    private final boolean[][] MAP;
    private Queue<Point> queuePoint;

    public CreateMap(int width, int height) {
        this.MAP_WIDTH = width;
        this.MAP_HEIGHT = height;

        MAP = new boolean[width][height];
        queuePoint = new ArrayDeque<>();

        // случайные точки начала
        int rndX = (int) (Math.random() * MAP_WIDTH);
        int rndY = (int) (Math.random() * MAP_HEIGHT);
        queuePoint.add(new Point(rndX, rndY));

        createLabirint();
        PrintMap();
    }


    /*
     * метод реализует создание идеального лабиринта
     * Логика метода: На вход передается случайная точка, метод определяет в какие точки можно пойти из это точки,
     * создает список этих точек, случайным образом выбирает в какую точку может пойти, удаляет выбранную точку
     * из нашего списка, отправляет наш список в очередь точек, для выбранной точки метод начинается сначала
     * */
    public void createLabirint() {
        while (!queuePoint.isEmpty()) {
            Point point = queuePoint.poll();
            MAP[point.getX()][point.getY()] = true;
            int rndPoint = (int) (Math.random() * 4);
            switch (rndPoint) {
                case (0):
                    if (0 <= point.getX() - 2 && !MAP[point.getX() - 2][point.getY()]) {
                        MAP[point.getX() - 2][point.getY()] = true;
                        MAP[point.getX() - 1][point.getY()] = true;
                        if (point.getX() + 2 < MAP_WIDTH)
                            queuePoint.add(new Point(point.getX() + 2, point.getY()));
                        if (0 <= point.getY() - 2)
                            queuePoint.add(new Point(point.getX(), point.getY() - 2));
                        if (point.getY() + 2 < MAP_HEIGHT)
                            queuePoint.add(new Point(point.getX(), point.getY() + 2));
                    }
                    break;
                case (1):
                    if (point.getX() + 2 < MAP_WIDTH && !MAP[point.getX() + 2][point.getY()]) {
                        MAP[point.getX() + 2][point.getY()] = true;
                        MAP[point.getX() + 1][point.getY()] = true;
                        if (0 <= point.getX() - 2)
                            queuePoint.add(new Point(point.getX() - 2, point.getY()));
                        if (point.getY() + 2 < MAP_HEIGHT)
                            queuePoint.add(new Point(point.getX(), point.getY() + 2));
                        if (0 <= point.getY() - 2)
                            queuePoint.add(new Point(point.getX(), point.getY() - 2));
                    }
                    break;
                case (2):
                    if (point.getY() + 2 < MAP_HEIGHT && !MAP[point.getX()][point.getY() + 2]) {
                        MAP[point.getX()][point.getY() + 2] = true;
                        MAP[point.getX()][point.getY() + 1] = true;
                        if (point.getX() + 2 < MAP_WIDTH)
                            queuePoint.add(new Point(point.getX() + 2, point.getY()));
                        if (0 <= point.getX() - 2)
                            queuePoint.add(new Point(point.getX() - 2, point.getY()));
                        if (0 <= point.getY() - 2)
                            queuePoint.add(new Point(point.getX(), point.getY() - 2));
                    }
                    break;
                case (3):
                    if (0 <= point.getY() - 2 && !MAP[point.getX()][point.getY() - 2]) {
                        MAP[point.getX()][point.getY() - 2] = true;
                        MAP[point.getX()][point.getY() - 1] = true;
                        if (point.getX() + 2 < MAP_WIDTH)
                            queuePoint.add(new Point(point.getX() + 2, point.getY()));
                        if (0 <= point.getX() - 2)
                            queuePoint.add(new Point(point.getX() - 2, point.getY()));
                        if (point.getY() + 2 < MAP_HEIGHT)
                            queuePoint.add(new Point(point.getX(), point.getY() + 2));
                    }
                    break;
            }

        }
    }

    /*
     * Метод реализует список точек, в которые мы можем пойти от изначальной точки
     * */
    public List<Point> addPointsList(Point point) {
        List<Point> list = new ArrayList<>();
        // Если можно отправится влево на 2 точки и там стоит 0
        if (0 <= point.getX() - 2 && !MAP[point.getX() - 2][point.getY()]) {
            list.add(new Point(point.getX() - 2, point.getY()));
        }
        // Если можно отправится право на 2 точки и там стоит 0
        if (point.getX() + 2 < MAP_WIDTH && !MAP[point.getX() + 2][point.getY()]) {
            list.add(new Point(point.getX() + 2, point.getY()));
        }
        // Если можно отправится вверх на 2 точки и там стоит 0
        if (point.getY() + 2 < MAP_HEIGHT && !MAP[point.getX()][point.getY() + 2]) {
            list.add(new Point(point.getX(), point.getY() + 2));
        }
        // Если можно отправится вниз на 2 точки и там стоит 0
        if (0 <= point.getY() - 2 && !MAP[point.getX()][point.getY() - 2]) {
            list.add(new Point(point.getX(), point.getY() - 2));
        }
        return list;
    }

    //записываем наши данные в файлы
    public void PrintMap() {
        try {
            WriteMap writeMap = new WriteMap(MAP);
            writeMap.writeMap();
        } catch (IOException e) {
        }
    }

}