package mishka.calculatorsandbox.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mishka.calculatorsandbox.model.calculator.CalculatorInputEvent;
import mishka.calculatorsandbox.R;

public class SimpleCalculatorView implements CalculatorView, View.OnClickListener {
    private View view;
    private CalculatorEventListener listener;
    private TextView expression, result;
    private Button digit0, digit1, digit2, digit3, digit4, digit5, digit6, digit7, digit8, digit9;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide, btnLeftParenthesis, btnRightParenthesis, btnResult;

    public SimpleCalculatorView(LayoutInflater inflater, ViewGroup rootView) {
        view = inflater.inflate(R.layout.calculator_view, rootView, false);
        initialize();
    }

    private void initialize() {
        digit0 = view.findViewById(R.id.digit_0);
        digit1 = view.findViewById(R.id.digit_1);
        digit2 = view.findViewById(R.id.digit_2);
        digit3 = view.findViewById(R.id.digit_3);
        digit4 = view.findViewById(R.id.digit_4);
        digit5 = view.findViewById(R.id.digit_5);
        digit6 = view.findViewById(R.id.digit_6);
        digit7 = view.findViewById(R.id.digit_7);
        digit8 = view.findViewById(R.id.digit_8);
        digit9 = view.findViewById(R.id.digit_9);

        digit0.setOnClickListener(this);
        digit1.setOnClickListener(this);
        digit2.setOnClickListener(this);
        digit3.setOnClickListener(this);
        digit4.setOnClickListener(this);
        digit5.setOnClickListener(this);
        digit6.setOnClickListener(this);
        digit7.setOnClickListener(this);
        digit8.setOnClickListener(this);
        digit9.setOnClickListener(this);

        btnPlus = view.findViewById(R.id.plus);
        btnMinus = view.findViewById(R.id.minus);
        btnMultiply = view.findViewById(R.id.multiply);
        btnDivide = view.findViewById(R.id.division);
        btnLeftParenthesis = view.findViewById(R.id.parenthesis_left);
        btnRightParenthesis = view.findViewById(R.id.parenthesis_right);
        btnResult = view.findViewById(R.id.result);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnLeftParenthesis.setOnClickListener(this);
        btnRightParenthesis.setOnClickListener(this);
        btnResult.setOnClickListener(this);

        expression = view.findViewById(R.id.expression);
        result = view.findViewById(R.id.result_display);
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void setListener(CalculatorEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void update(String expression, String result) {
        this.expression.setText(expression);
        this.result.setText(result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.digit_0:
                listener.onCalculatorEvent(CalculatorInputEvent.on0Click);
                break;
            case R.id.digit_1:
                listener.onCalculatorEvent(CalculatorInputEvent.on1Click);
                break;
            case R.id.digit_2:
                listener.onCalculatorEvent(CalculatorInputEvent.on2Click);
                break;
            case R.id.digit_3:
                listener.onCalculatorEvent(CalculatorInputEvent.on3Click);
                break;
            case R.id.digit_4:
                listener.onCalculatorEvent(CalculatorInputEvent.on4Click);
                break;
            case R.id.digit_5:
                listener.onCalculatorEvent(CalculatorInputEvent.on5Click);
                break;
            case R.id.digit_6:
                listener.onCalculatorEvent(CalculatorInputEvent.on6Click);
                break;
            case R.id.digit_7:
                listener.onCalculatorEvent(CalculatorInputEvent.on7Click);
                break;
            case R.id.digit_8:
                listener.onCalculatorEvent(CalculatorInputEvent.on8Click);
                break;
            case R.id.digit_9:
                listener.onCalculatorEvent(CalculatorInputEvent.on9Click);
                break;
            case R.id.plus:
                listener.onCalculatorEvent(CalculatorInputEvent.onPlusClick);
                break;
            case R.id.minus:
                listener.onCalculatorEvent(CalculatorInputEvent.onMinusClick);
                break;
            case R.id.multiply:
                listener.onCalculatorEvent(CalculatorInputEvent.onMultiplyClick);
                break;
            case R.id.division:
                listener.onCalculatorEvent(CalculatorInputEvent.onDivisionClick);
                break;
            case R.id.parenthesis_left:
                listener.onCalculatorEvent(CalculatorInputEvent.onLeftParenthesisClick);
                break;
            case R.id.parenthesis_right:
                listener.onCalculatorEvent(CalculatorInputEvent.onRightParenthesisClick);
                break;
            case R.id.result:
                listener.onCalculatorEvent(CalculatorInputEvent.onResultClick);
                break;
        }
    }
}
