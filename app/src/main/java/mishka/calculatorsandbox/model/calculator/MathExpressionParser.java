package mishka.calculatorsandbox.model.calculator;

/**
 * Created by Mishka on 01.03.2018.
 */

public class MathExpressionParser {
    public static MathExpression parse(String s) {
        if (s.toCharArray()[0] == '-')
            s = '0' + s;

        MathExpression expression = parseMathNodes(s);

        MathExpression rPNExpression = new MathExpression();
        MyStack<OperatorNode> operatorsStack = new MyStack<>();
        OperatorNode lastNode;
        for (MathExpressionNode node : expression) {
            if (node.isOperator()) {
                OperatorNode currentNode = (OperatorNode) node;
                lastNode = operatorsStack.last();
                if (lastNode == null) {
                    operatorsStack.push(currentNode);
                } else {
                    while (true) {
                        if (currentNode.isPriorityLessOfEquals(lastNode)) {
                            rPNExpression.add(operatorsStack.pop());
                            lastNode = operatorsStack.last();
                            if (lastNode == null) {
                                operatorsStack.push(currentNode);
                                break;
                            }
                        } else {
                            operatorsStack.push(currentNode);
                            break;
                        }
                    }
                }
            } else {
                rPNExpression.add(node);
            }
        }

        while (!operatorsStack.isEmpty())
            rPNExpression.add(operatorsStack.pop());

        return rPNExpression;
    }

    public static MathExpression parseMathNodes(String s) {
        MathExpression expression = new MathExpression();
        MathExpressionNode tempNode = new NumberNode();
        MathExpressionNode previousNode = null;
//        for (char ch : s.toCharArray()) {
//
//            tempNode = tempNode.addChar(ch);
//            if (!expression.contains(tempNode)) {
//                expression.add(tempNode);
//            }
//        }
        for (char ch : s.toCharArray()) {
            if (previousNode == null)
                tempNode = new NumberNode(ch);
            else if (previousNode.isOperator()) {
                tempNode = new NumberNode(ch);
            } else {
                if (MathExpressionNode.isOperator(ch))
                    tempNode = new OperatorNode(ch);
                else tempNode.addChar(ch);
            }

            if (!expression.contains(tempNode)) {
                expression.add(tempNode);
                previousNode = tempNode;
            }

        }
        return expression;
    }
}
