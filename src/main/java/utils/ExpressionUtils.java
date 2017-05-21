package utils;

/**
 * @author Aman
 */
public interface ExpressionUtils {
    public static Number evaluateBinaryExpression(Number num1, Number num2, Operands operand) {
        switch (operand) {
            case ADDITION:
                return num1.doubleValue() + num2.doubleValue();
            case SUBTRACTION:
                return num1.doubleValue() - num2.doubleValue();
            case MULTIPLICATION:
                return num1.doubleValue() * num2.doubleValue();
            case DIVISION:
                return num1.doubleValue() / num2.doubleValue();
            default:
                throw new UnsupportedOperationException("Operator Unsupported");

        }
    }

    public static Number evaluateUnaryExpression(Number number, Operands operand) {
        switch (operand) {
            case SINE:
                return Math.sin(number.doubleValue());
            case COSINE:
                return Math.cos(number.doubleValue());
            case TAN:
                return Math.tan(number.doubleValue());
            default:
                throw new UnsupportedOperationException("Operator Unsupported");
        }
    }

    public static boolean isEmptyString(String string) {
        return string != null && string.length() != 0;
    }
}
