
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
        sortList();
    }
    public void collectBeeperSteeple() {
        collectColumn();
        beeperList [index]= tempCount;
        printBeeperList();
        resetPosition();
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
        faceEast();
        move();
        index++;
        tempCount= 0;
    }
    public void sortList() {
        for (int x=0; x<8; x++) {
        if (beeperList[index] > beeperList[index+1]) {
            sortedList[index] = beeperList[index+1];
            sortedList[index+1] = beeperList[index];
        }
        else {
            sortedList[index+1] = beeperList[index+1];
            sortedList[index]= beeperList[index];
        }
        printSortedList();
    }
}
    public void printBeeperList() {
        System.out.println();
        for (int value: beeperList) {
            System.out.print (value + "," );
        }
        System.out.println();
    }
    public void printSortedList() {
        System.out.println();
        for (int value: sortedList) {
            System.out.print (value + "," );
        }
        System.out.println();
    }
   
}

