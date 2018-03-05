package mishka.calculatorsandbox.presenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mishka.calculatorsandbox.model.calculator.CalculatorInputEvent;
import mishka.calculatorsandbox.model.Calculator;
import mishka.calculatorsandbox.model.SimpleCalculator;
import mishka.calculatorsandbox.model.calculator.MathExpressionParser;
import mishka.calculatorsandbox.view.CalculatorView;
import mishka.calculatorsandbox.view.SimpleCalculatorView;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView.CalculatorEventListener, Calculator.OutputListener {
    private CalculatorView calculatorView;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculatorView = new SimpleCalculatorView(getLayoutInflater(), null);
        calculatorView.setListener(this);
        calculator = new SimpleCalculator();
        calculator.setListener(this);
        setContentView(calculatorView.getView());

        String testExp = "5-3*76+1+34/32-4.12+55543*6*9";
//        System.out.println(testExp + " --> " + MathExpressionParser.parse(testExp));
        System.out.println(testExp + " --> " + MathExpressionParser.parseMathNodes(testExp));
    }

    @Override
    public void onCalculatorEvent(CalculatorInputEvent calculatorInputEvent) {
        calculator.onCalculatorInputEvent(calculatorInputEvent);
    }

    @Override
    public void onChange(String expression, String result) {
        calculatorView.update(expression, result);
    }
}
