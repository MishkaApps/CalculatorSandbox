package mishka.calculatorsandbox.model.calculator;

import java.util.ArrayList;

/**
 * Created by Mishka on 01.03.2018.
 */

public class MathExpression extends ArrayList<MathExpressionNode>{
    @Override
    public String toString() {
        String res = "";
        for(MathExpressionNode node: this){
            res += "{" + node.getValue() + "}=>";
        }
        res += " = ";
        return res;
    }
}
