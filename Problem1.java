
import kareltherobot.*; 


/**
 * @author :  A. Starr
 */
public class Problem1 extends Robot
{
    int[] beeperList = new int[8];
    int tempCount = 0;
    int index = 0;
    int[] sortedList = new int[8];
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers() {
        for (int x=0; x<8; x++) {
            collectBeeperSteeple();
        }
        rearrange();
    }
    public void collectBeeperSteeple() {
        countBeepers();
        resetPosition();
        printBeeperList();
    }
    public void countBeepers() {
        collectColumn();
        beeperList [index]= tempCount;
        index++;
        tempCount= 0;
    }
    public void collectColumn() {
        faceNorth();
        while (nextToABeeper()) {
            pickBeeper();
            tempCount++;
            move();
        }
    }
    public void faceNorth() {
        while (!facingNorth()) {
            turnLeft();
        }
    }
    public void resetPosition() {
        faceSouth();
        while (frontIsClear()) {
            move();
        }
        faceEast();
        move();
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
    public void printBeeperList() {
        System.out.println("Beeper List");
        for (int value: beeperList) {
            System.out.print (value + "," );
        }
        System.out.println();
    }
    
    public void rearrange() {
        sortList();
        printSortedList();
    }
    public void sortList() {
        if (beeperList[0] > beeperList[1]) {
            sortedList[0] = beeperList[1];
            sortedList[1] = beeperList[0];
        }
        else {
            sortedList[1] = beeperList[1];
            sortedList[0]= beeperList[0];
        }
    }
    public void printSortedList() {
        System.out.println("Sorted List");
        for (int value: sortedList) {
            System.out.print (value + "," );
        }
        System.out.println();
    }
}

