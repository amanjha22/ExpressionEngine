package nonterminals;

import core.Expression;

import java.util.Objects;

/**
 * @author Aman
 */
public abstract class UnaryExpression implements Expression {
    Expression expression;

    public UnaryExpression(Expression expression) {
        this.expression = Objects.requireNonNull(expression);
    }

    public Expression getExpression() {
        return expression;
    }

}
