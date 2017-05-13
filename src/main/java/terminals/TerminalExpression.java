package terminals;

import core.Expression;

import java.util.Objects;

/**
 * @author Aman
 */


public class TerminalExpression implements Expression {
    private Number terminal;

    public TerminalExpression(Number terminal) {
        this.terminal = Objects.requireNonNull(terminal);
    }

    public Number getTerminal() {
        return terminal;
    }

    public void setTerminal(Number terminal) {
        this.terminal = Objects.requireNonNull(terminal);
    }

    @Override
    public Number evaluateExpression() {
        return getTerminal();
    }
}
