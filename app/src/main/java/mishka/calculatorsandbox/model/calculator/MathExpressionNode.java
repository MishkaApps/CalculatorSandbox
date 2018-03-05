package mishka.calculatorsandbox.model.calculator;

/**
 * Created by Mishka on 01.03.2018.
 */

public abstract class MathExpressionNode {

    abstract MathExpressionNode addChar(char ch);

    static boolean isOperator(char ch){
         if("+-*/()".indexOf(ch) >= 0)
             return true;
         else return false;
    }

    abstract String getValue();

    abstract boolean isOperator();
}
