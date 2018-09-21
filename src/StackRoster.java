import java.util.Arrays;

public class StackRoster {

    private Student[] rosterArray;
    private int stackSize;
    private int topOfStack = -1;

    public StackRoster(int size) {
        stackSize = size;
        rosterArray = new Student[size];
        Arrays.fill(rosterArray, "-1");
    }

    public void push(Student input) {
        if(topOfStack+1 < stackSize){
            topOfStack++;
            rosterArray[topOfStack] = input;
        }
        else
            System.out.println("Sorry, but the stack is full");
        displayTheStack();
        System.out.println(input + ": was added to the stack");
    }

    public Student pop() {
        if(topOfStack >= 0){
            displayTheStack();
            System.out.println(rosterArray[topOfStack] + ": was removed from the stack");
            rosterArray[topOfStack] = null;
            return rosterArray[topOfStack--];
        }
        else {
            displayTheStack();
            System.out.println("Sorry, but the stack is empty");
            return null;
        }
    }

    public Student peek() {
        displayTheStack();
        System.out.println(rosterArray[topOfStack] + ": is at the top of the stack");
        return rosterArray[topOfStack];
    }

    public void pushMany(Student[] multipleValues){
        for(int i = 0; i < multipleValues.length; i++){
            push(multipleValues[i]);
        }
    }

    public void popAll() {
        for(int i = topOfStack; i >= 0; i--){
            pop();
        }
    }

    public void popDisplayAll(){
        Student[] theReverse = null;
        for(int i = topOfStack; i >= 0; i--){
            theReverse[i] = rosterArray[i];
        }
        System.out.println("The Reverse: ");
        displayTheStack();
        popAll();
    }

    public void displayTheStack() {
        for(int n = 0; n < 61; n++)
            System.out.print("-");
        System.out.println();
        for(int n = 0; n < stackSize; n++){
            System.out.format("| %2s "+ " ", n);
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < stackSize; n++){
            if(rosterArray[n] == null)
                System.out.print("|     ");
            else
                System.out.print(String.format("| %2s "+ " ", rosterArray[n]));
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();
    }
}
