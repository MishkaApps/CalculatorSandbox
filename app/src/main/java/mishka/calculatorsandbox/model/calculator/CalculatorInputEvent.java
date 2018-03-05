package mishka.calculatorsandbox.model.calculator;

public enum CalculatorInputEvent {
    on0Click('0'),
    on1Click('1'),
    on2Click('2'),
    on3Click('3'),
    on4Click('4'),
    on5Click('5'),
    on6Click('6'),
    on7Click('7'),
    on8Click('8'),
    on9Click('9'),
    onPlusClick('+'),
    onMinusClick('-'),
    onMultiplyClick('*'),
    onDivisionClick('/'),
    onLeftParenthesisClick('('),
    onRightParenthesisClick(')'),
    onResultClick('=');

    private char eventChar;

    CalculatorInputEvent(char ch) {
        eventChar = ch;
    }

    public char getEventChar() {
        return eventChar;
    }

    public boolean isDigit() {
        if ("0123456789".indexOf(eventChar) >= 0)
            return true;
        else return false;
    }
}
