package mishka.calculatorsandbox.model.calculator;

/**
 * Created by Mishka on 02.03.2018.
 */

public class NumberNode extends MathExpressionNode {
    private String value;

    public NumberNode(char ch) {
        value = "" + ch;
    }

    public NumberNode() {
        value = "";
    }

    @Override
    MathExpressionNode addChar(char ch) {
        if (isOperator(ch))
            return new OperatorNode(ch);

        value += ch;
        return this;
    }

    @Override
    String getValue() {
        return value;
    }

    @Override
    boolean isOperator() {
        return false;
    }
}
