package mishka.calculatorsandbox.model.calculator;

/**
 * Created by Mishka on 02.03.2018.
 */

public class OperatorNode extends MathExpressionNode {
    private char value;
    private Priority priority;

    public OperatorNode(char ch) {
        value = ch;
        switch (value) {
            case '*':
            case '/':
                priority = Priority.HIGH;
                break;
            case '+':
            case '-':
                priority = Priority.MIDDLE;
                break;
        }
    }

    @Override
    MathExpressionNode addChar(char ch) {
        if (isOperator(ch))
            return new OperatorNode(ch);
        else return new NumberNode(ch);
    }

    @Override
    String getValue() {
        return "" + value;
    }


    @Override
    boolean isOperator() {
        return true;
    }

    public boolean isPriorityLessOfEquals(OperatorNode node) {
        return !priority.isPriorityGreater(node.priority);
    }

    enum Priority {
        HIGH(2), MIDDLE(1);
        int priorityValue;

        Priority(int priorityValue) {
            this.priorityValue = priorityValue;
        }

        boolean isPriorityGreater(Priority priority) {
            return priorityValue > priority.priorityValue;
        }
    }
}
