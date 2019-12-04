package ru.stqa.pft.sandbox.task2;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        double distanceX = this.getX() - p.getX();
        double distanceY = this.getY() - p.getY();
        return Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
