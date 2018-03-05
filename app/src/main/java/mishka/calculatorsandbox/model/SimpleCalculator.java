package mishka.calculatorsandbox.model;

import mishka.calculatorsandbox.model.calculator.CalculatorInputEvent;
import mishka.calculatorsandbox.model.calculator.MathExpression;
import mishka.calculatorsandbox.model.calculator.MathExpressionParser;

public class SimpleCalculator implements Calculator {
    private StringBuilder expression;
    private String result;
    private OutputListener listener;

    public SimpleCalculator() {
        expression = new StringBuilder();
        result = "";
    }

    @Override
    public void onCalculatorInputEvent(CalculatorInputEvent inputEvent) {

        if (inputEvent == CalculatorInputEvent.onResultClick)
            calculateExpression();
        else expression.append(inputEvent.getEventChar());

        notifyListener();
    }

    private void calculateExpression() {
        MathExpression mathExpression = MathExpressionParser.parse(expression.toString());
        System.out.println("math expression: " + mathExpression);
    }

    private void notifyListener() {
        listener.onChange(expression.toString(), result);
    }

    @Override
    public void setListener(OutputListener listener) {
        this.listener = listener;
    }


}
