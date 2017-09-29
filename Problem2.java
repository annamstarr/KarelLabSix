
import kareltherobot.*; 


/**
 * @author :  A. Starr
 */
public class Problem2 extends Robot
{
    int beepers = 0;
    public Problem2(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void buildFence() {
        faceNorth();
        while (!nextToABeeper()) {
            move();
        }
        countBeepers();
        findWall();
        turnRight();
        while (frontIsClear()) {
            build();
        }
        returnToOrgin();
        turnOff();
    }
    public void faceNorth() {
        while (!facingNorth()) {
            turnLeft();
        }
    }
    public void countBeepers() {
        while (nextToABeeper()) {
            pickBeeper();
            beepers++;
        }
    }
    public void findWall() {
        move();
        faceEast();
        while (frontIsClear()) {
            move();
        }
    }
    public void faceEast() {
        while (!facingEast()) {
            turnLeft();
        }
    }
    public void build() {
            if (!nextToABeeper()) {
                turnLeft();
                if (!frontIsClear()) {
                    putBeeper();
                    turnRight();
                    move();
                }
                else {
                    goAroundEdge();
                }
            }
    }
    public void returnToOrgin() {
        while (frontIsClear()) {
            move();
        }
        turnRight();
        while (frontIsClear()) {
            move();
        }
    }
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    public void goAroundEdge() {
        move();
        turnLeft();
        move();
        turnLeft();
        move();
        turnRight();
    }
}

