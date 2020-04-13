package Exercise_15_33;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;


public class GBeanMachine extends Pane {
    private int balls;
    private int slots;
    private int currentBall;
    private BeanMachine beanMachine;
    private int[] slotRegistry;
    private double uRadius;
    private Line[] slotLines;
    private Line topLineLeft;
    private Line topLineRight;

    public GBeanMachine(int balls, int slots) {
        this.balls = balls;
        this.slots = slots;
        currentBall = 0;
        this.beanMachine = new BeanMachine(balls, slots);
        slotRegistry = new int[slots];
        uRadius = 10;
        this.slotLines = new Line[slots + 1];

        drawBeanMachine();
        startBeanMachine();
    }

    private void startBeanMachine() {
        KeyFrame kf = new KeyFrame(Duration.millis(3000), e -> dropBall(currentBall));
        Timeline t1 = new Timeline(kf);
        t1.setCycleCount(balls);
        t1.play();
    }

    private void dropBall(int ball) {
        Polyline poly = generatePolylinePath(beanMachine.getPaths()[ball]);
        Circle circle = new Circle(uRadius);
        circle.setFill(Color.ORANGE);

        getChildren().addAll(circle);

        PathTransition pt = new PathTransition(Duration.millis(3000), poly, circle);
        pt.setCycleCount(0);
        pt.play();

        currentBall++;
    }

    private Polyline generatePolylinePath(boolean[] path) {
        Polyline poly = new Polyline();

        // Draw path of ball through main entry
        double x = getMachineWidth() / 2;
        double y = 0;
        poly.getPoints().addAll(x, y);
        y = getUDiameter() * 2 + uRadius;
        poly.getPoints().addAll(x, y);

        // Draw path of ball through the center of machine
        Point2D pointAfterArc = new Point2D(0, 0);
        for (int i = 0; i < path.length; i++) {
            pointAfterArc = path[i] ? drawRightArc(poly) : drawLeftArc(poly);
            if (i < path.length - 1) {
                x = pointAfterArc.getX();
                y = pointAfterArc.getY() + getUDiameter();
                poly.getPoints().addAll(x, y);
            }
        }

        // Draw path of ball into the slot
        x = pointAfterArc.getX();
        y = getMachineHeight() - uRadius - (getUDiameter() * slotRegistry[getSlotForPath(path)]);
        poly.getPoints().addAll(x, y);
        registerSlotForPath(path);
        return poly;
    }

    private Point2D drawLeftArc(Polyline p) {
        double cx = p.getPoints().get(p.getPoints().size() - 2);
        double cy = p.getPoints().get(p.getPoints().size() - 1);
        double rx = cx;
        double ry = cy + getUDiameter();

        for (int i = 270; i >= 180; i--) {
            double x = rx + getUDiameter() * Math.cos(Math.toRadians(i));
            double y = ry + getUDiameter() * Math.sin(Math.toRadians(i));
            p.getPoints().addAll(x, y);
            cx = x;
            cy = y;
        }
        return new Point2D(cx, cy);
    }

    private Point2D drawRightArc(Polyline p) {
        double cx = p.getPoints().get(p.getPoints().size() - 2);
        double cy = p.getPoints().get(p.getPoints().size() - 1);
        double rx = cx;
        double ry = cy + getUDiameter();

        for (int i = 270; i <= 360; i++) {
            double x = rx + getUDiameter() * Math.cos(Math.toRadians(i));
            double y = ry + getUDiameter() * Math.sin(Math.toRadians(i));
            p.getPoints().addAll(x, y);
            cx = x;
            cy = y;
        }
        return new Point2D(cx, cy);
    }

    private void registerSlotForPath(boolean[] path) {
        int rightCount = 0;
        for (int i = 0; i < path.length; i++) {
            if (path[i]) {
                rightCount++;
            }
        }
        slotRegistry[rightCount]++;
    }

    private int getSlotForPath(boolean[] path) {
        int rightCount = 0;
        for (int i = 0; i < path.length; i++) {
            if (path[i]) {
                rightCount++;
            }
        }
        return rightCount;
    }

    private void drawBeanMachine() {
        drawBaseline();
        drawSlots();
        drawTopLines();
        drawSideLines();
        drawPegs();
    }

    private void drawBaseline() {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(getMachineHeight());
        line.setEndX(getMachineWidth());
        line.setEndY(getMachineHeight());
        getChildren().add(line);
    }

    private void drawSlots() {
        double xPos = 0;
        for (int i = 0; i < slotLines.length; i++) {
            Line line = new Line();
            line.setStartX(xPos);
            line.setStartY(getMachineHeight());
            line.setEndX(xPos);
            line.setEndY(getMachineHeight() - (balls * getUDiameter()));
            slotLines[i] = line;
            getChildren().add(line);
            xPos += getUDiameter() * 2;
        }
    }

    private void drawTopLines() {
        drawTopLineLeft();
        drawTopLineRight();
    }

    private void drawTopLineLeft() {
        Line line = new Line();
        line.setStartX(getMachineWidth() / 2 - getUDiameter());
        line.setStartY(0);
        line.setEndX(line.getStartX());
        line.setEndY(getUDiameter() * 2);
        topLineLeft = line;
        getChildren().add(line);
    }

    private void drawTopLineRight() {
        Line line = new Line();
        line.setStartX(getMachineWidth() / 2 + getUDiameter());
        line.setStartY(0);
        line.setEndX(line.getStartX());
        line.setEndY(getUDiameter() * 2);
        topLineRight = line;
        getChildren().add(line);
    }

    private void drawSideLines() {
        drawSideLineLeft();
        drawSideLineRight();
    }

    private void drawSideLineLeft() {
        Line line = new Line();
        line.setStartX(slotLines[0].getEndX());
        line.setStartY(slotLines[0].getEndY());
        line.setEndX(topLineLeft.getEndX());
        line.setEndY(topLineLeft.getEndY());
        getChildren().add(line);
    }

    private void drawSideLineRight() {
        Line line = new Line();
        line.setStartX(slotLines[slotLines.length - 1].getEndX());
        line.setStartY(slotLines[slotLines.length - 1].getEndY());
        line.setEndX(topLineRight.getEndX());
        line.setEndY(topLineRight.getEndY());
        getChildren().add(line);
    }

    private void drawPegs() {
        int rows = slots - 1;

        for (int i = rows, pad = 0; i > 0; i--, pad++) {
            for (int j = 0; j < i; j++) {
                double xPos = (getUDiameter() * 2) + (getUDiameter() * pad) + (getUDiameter() * 2 * j);
                double yPos = (getMachineHeight() - balls * getUDiameter()) - (getUDiameter() * 2 * pad);
                Circle peg = new Circle(uRadius);
                peg.setCenterX(xPos);
                peg.setCenterY(yPos);
                getChildren().add(peg);
            }
        }
    }

    private double getMachineWidth() {
        return getUDiameter() * 2 * slots;
    }

    private double getMachineHeight() {
        return (balls * getUDiameter() + uRadius) + ((slots - 1) * (getUDiameter() * 2) - getUDiameter()) + (getUDiameter() * 2);
    }

    private double getUDiameter() {
        return uRadius * 2;
    }
}
