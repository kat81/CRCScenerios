import java.util.Arrays;

public class QueueRoster {

    private Student[] rosterArray;
    private int queueSize;
    private int front, numberOfItems, rear = 0;

    public QueueRoster(int size) {
        this.queueSize = size;
        rosterArray = new Student[size];
        Arrays.fill(rosterArray, "-1");
    }

    public void insert(Student input) {
        if(numberOfItems + 1 <= queueSize) {
            rosterArray[rear] = input;
            rear++;
            numberOfItems++;
            System.out.println(input + ": was added to the queue");
        }
        else {
            System.out.println("Sorry, but the queue is full");
        }
    }

    public void remove() {
        if(numberOfItems > 0){
            System.out.println(rosterArray[front] + ": was removed from the queue\n");
            rosterArray[front] = null;
            front++;
            numberOfItems--;
        }
        else {
            System.out.println("Sorry, but the queue is empty");
        }
    }

    public void peek() {
        System.out.println("The first student is " + rosterArray[front]);
    }

    public void displayTheQueue() {
        for(int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();
        for(int n = 0; n < queueSize; n++) {
            System.out.format("| %2s "+ " ", n);
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();
        for(int n = 0; n < queueSize; n++) {
            if(rosterArray[n] == null)
                System.out.print("|     ");
            else
                System.out.print(String.format("| %2s "+ " ", rosterArray[n]));
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();
        // Number of spaces to put before the F
        int spacesBeforeFront = 3*(2*(front+1)-1);
        for(int k = 1; k < spacesBeforeFront; k++)
            System.out.print(" ");
        System.out.print("F");
        // Number of spaces to put before the R
        int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
        for(int l = 0; l < spacesBeforeRear; l++)
            System.out.print(" ");
        System.out.print("R");
        System.out.println("\n");
    }
}
