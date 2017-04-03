package ru.rgbcircles;

class SimpleCircle {
    int x;
    int y;
    private int radius;

    SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getRadius() {
        return radius;
    }
}
