import java.util.ArrayList;

/**
 * Created by schandramouli on 9/27/15.
 */

public class SetOfStacks {
    // This is only an integer implementation
    // Will eventually make it a Generic one
    int capacity = 10; // hold only ten items in any stack
    int currentCapacity = 0;
    ArrayList<Stack<Integer>> setOfStacks = new ArrayList<Stack<Integer>>();

    public SetOfStacks() {
        setOfStacks.add(0, new Stack<Integer>(capacity));
    }

    public void push(int data) {
        if (currentCapacity >= capacity) {
            // we need to create a new stack and push onto it
            setOfStacks.add(new Stack<Integer>(capacity));
            // reset current capacity
            currentCapacity = 0;
        }
        setOfStacks.get(setOfStacks.size() - 1)
                    .push(data);
        // update the current capacity
        currentCapacity++;
    }

    public int pop() {
        int data;
        if(currentCapacity <= 0) {
            // remove the current stack
            if(! setOfStacks.isEmpty()){
                setOfStacks.remove(setOfStacks.size() - 1);
            } else {
                return -1;
            }
            // reset the current capacity to capacity of previous stack - 2 ~ 8
            currentCapacity = capacity;
        }
        // pop the right stack
        data = setOfStacks.get(setOfStacks.size() - 1)
                .pop();
        // update the current capacity
        currentCapacity--;
        return data;
    }

    @Override
    public String toString() {
        return setOfStacks.toString();
    }

    public static void main(String[] args) {
        // driver program
        SetOfStacks SOS = new SetOfStacks();
        int i = 0;
        while (i < 21) {
            SOS.push(i);
            i++;
        }
        System.out.println(SOS);

        while (i > 9) {
            System.out.print(" " + SOS.pop());
            i--;
        }
        SOS.push(10);
        SOS.push(11);

        System.out.println(SOS);
    }
}