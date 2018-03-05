package mishka.calculatorsandbox.view;


import mishka.calculatorsandbox.model.calculator.CalculatorInputEvent;

public interface CalculatorView extends MVCView {
    void setListener(CalculatorEventListener calculatorEventListener);
    void update(String expression, String result);

    interface CalculatorEventListener {
        void onCalculatorEvent(CalculatorInputEvent calculatorEvent);
    }

}
