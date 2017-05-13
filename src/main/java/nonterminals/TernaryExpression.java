package nonterminals;

import core.Expression;

import java.util.Objects;

/**
 * @author Aman
 */
public abstract class TernaryExpression implements Expression {
    private Expression expression1;
    private Expression expression2;
    private Expression expression3;

    public TernaryExpression(Expression expression1, Expression expression2, Expression expression3) {
        this.expression1 = Objects.requireNonNull(expression1);
        this.expression2 = Objects.requireNonNull(expression2);
        this.expression3 = Objects.requireNonNull(expression3);
    }

    public Expression getExpression1() {
        return expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }

    public Expression getExpression3() {
        return expression3;
    }
}
