package ru.stqa.pft.sandbox.task2;

public class Main {
    public static void main(String[] args) {
        System.out.println(distance(new Point(0.0, 0.0), new Point(1.0, 1.0)));

        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(1.0, 1.0);
        System.out.println(p1.distance(p2));
    }

    public static double distance(Point p1, Point p2) {
        double distanceX = p1.getX() - p2.getX();
        double distanceY = p1.getY() - p2.getY();
        return Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
    }

}
