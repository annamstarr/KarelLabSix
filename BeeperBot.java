
import kareltherobot.*; 


/**
 * @author :  A. Starr
 */
public class BeeperBot extends Robot
{
    //instance variable to store beeper count
    int[] beeperList = new int[13];
    int tempCount = 0;
    
    public BeeperBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findAndCountBeepers() {
        while (frontIsClear()) {
            collectBeeperSteeple();
        }
    }
    
    public int[] getBeeperList() {
            //This will be used to print the beepers found.  No need to modify.
            return beeperList;
    }
    
    public void collectBeeperSteeple() {
        findBeepers();
        }
        public void findBeepers() {
        faceEast();
        while (!nextToABeeper() && (frontIsClear())) {
            move();
        }
        collectColumn();
        resetPosition();
        faceEast();
    }
    public void collectColumn() {
        faceNorth();
        while (nextToABeeper()) {
            pickBeeper();
            tempCount++;
            move();
        }
        column [0]= tempCount;
        resetTempCount();
    }
    public void faceNorth() {
        while (!facingNorth()) {
            turnLeft();
        }
    }
    public void faceSouth() {
        while(!facingSouth()) {
               turnLeft();
            }
        }
        public void faceEast() {
        while (!facingEast()) {
            turnLeft();
        }
    }
    public void resetPosition() {
        faceSouth();
        while (frontIsClear()) {
            move();
        }
    }
    public void resetTempCount() {
        tempcount= 0;
    }
    
}

