package mishka.calculatorsandbox.model.calculator;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Mishka on 02.03.2018.
 */

public class MyStack<T> {
    private LinkedList<T> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    public void push(T t) {
        stack.push(t);
    }

    public T pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T last() {

        return isEmpty() ? null : stack.getLast();

    }
}
