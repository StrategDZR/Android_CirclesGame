package ru.rgbcircles;

import android.graphics.Color;

class MainCircle extends SimpleCircle {

    private static final int INIT_RADIUS = 30;
    private static final int MAIN_SPEED = 50;
    private static final int MAIN_COLOR = Color.BLUE;

    MainCircle(int x, int y) {
        super(x, y, INIT_RADIUS);
        setColor(MAIN_COLOR);
    }

    void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = -(x - x1) * MAIN_SPEED / GameManager.getWidth();
        int dy = -(y - y1) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;
    }

    void initRadius() {
        radius = INIT_RADIUS;
    }

    void growRadius(SimpleCircle circle) {
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(circle.radius, 2));
    }
}
