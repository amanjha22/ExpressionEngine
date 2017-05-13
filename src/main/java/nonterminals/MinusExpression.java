package nonterminals;

import core.Expression;
import utils.ExpressionUtils;
import utils.Operands;

/**
 * @author Aman
 */
public class MinusExpression extends BinaryExpression {

    public MinusExpression(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public Number evaluateExpression() {
        Number num1 = this.getExpression1().evaluateExpression();
        Number num2 = this.getExpression2().evaluateExpression();

        return ExpressionUtils.evaluateBinaryExpression(num1, num2, Operands.SUBTRACTION);
    }
}
