package nonterminals;

import core.Expression;
import utils.ExpressionUtils;
import utils.Operands;

/**
 * @author Aman
 */
public class SineExpression extends UnaryExpression {

    public SineExpression(Expression expression) {
        super(expression);
    }

    @Override
    public Number evaluateExpression() {
        Number number = this.getExpression().evaluateExpression();

        return ExpressionUtils.evaluateUnaryExpression(number, Operands.SINE);
    }
}
