package ru.rgbcircles;

class MainCircle extends SimpleCircle {

    private static final int INIT_RADIUS = 30;
    private static final int MAIN_SPEED = 50;

    MainCircle(int x, int y) {
        super(x, y, INIT_RADIUS);
    }

    void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = -(x - x1) * MAIN_SPEED / GameManager.getWidth();
        int dy = -(y - y1) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;
    }
}
