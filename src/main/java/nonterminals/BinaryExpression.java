package nonterminals;

import core.Expression;

import java.util.Objects;

/**
 * @author Aman
 */
public abstract class BinaryExpression implements Expression {
    private Expression expression1;
    private Expression expression2;

    public BinaryExpression(Expression expression1, Expression expression2) {
        this.expression1 = Objects.requireNonNull(expression1);
        this.expression2 = Objects.requireNonNull(expression2);
    }

    public Expression getExpression1() {
        return expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }

}
