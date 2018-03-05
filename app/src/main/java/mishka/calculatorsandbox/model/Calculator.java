package mishka.calculatorsandbox.model;

import mishka.calculatorsandbox.model.calculator.CalculatorInputEvent;

public interface Calculator {
    void onCalculatorInputEvent(CalculatorInputEvent inputEvent);
    void setListener(OutputListener listener);
    interface OutputListener {
        void onChange(String expression, String result);
    }
}
