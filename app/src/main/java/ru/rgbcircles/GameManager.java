package ru.rgbcircles;

import java.util.ArrayList;

class GameManager {

    private static final int DIFFICULT = 10;
    private CanvasView canvasView;
    private static int width;
    private static int height;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;


    GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        SimpleCircle mailCircleArea = mainCircle.getCircleArea();
        circles = new ArrayList<>();
        for (int i = 0; i < DIFFICULT; i++) {
            EnemyCircle enemyCircle;
            do {
                enemyCircle = EnemyCircle.getRandomCircle();
            } while (enemyCircle.isIntersect(mailCircleArea));
            circles.add(enemyCircle);
        }
        calculateAndSetCirclesColor();

    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle: circles) {
            circle.setEnemyOrFoadColor(mainCircle);
        }
    }

    static int getWidth() {
        return width;
    }

    static int getHeight() {
        return height;
    }

    void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        moveCircles();
    }

    private void moveCircles() {
        for (EnemyCircle circle:circles) {
            circle.moveOneStep();
        }
    }
}
