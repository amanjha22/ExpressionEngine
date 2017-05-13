package core;

import nonterminals.DivideExpression;
import nonterminals.MinusExpression;
import nonterminals.MultiplyExpression;
import nonterminals.PlusExpression;
import terminals.TerminalExpression;
import utils.ExpressionRule;

import java.io.InvalidObjectException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Aman
 */
public class ExpressionGenerator {

    private static final String EXPRESSION_REGEX = "^(\\d+(\\.\\d+)?([-+/*](\\d)*(\\.\\d+)?)*)";
    private static final Pattern pattern = Pattern.compile(EXPRESSION_REGEX);
    private String expressionString;
    private ExpressionRule expressionRule;

    private ExpressionGenerator(String expressionString, ExpressionRule expressionRule) {
        this.expressionString = Objects.requireNonNull(expressionString);
        this.expressionRule = Objects.requireNonNull(expressionRule);
    }

    public static Expression getExpression(String expressionString, ExpressionRule expressionRule) throws InvalidObjectException {
        if (!validateExpression(expressionString))
            throw new InvalidObjectException("Expression Invalid");
        return new ExpressionGenerator(expressionString, expressionRule).generateExpression();
    }

    private static boolean validateExpression(String expressionString) {
        Matcher matcher = pattern.matcher(expressionString);
        return matcher.matches();
    }

    public Expression generateExpression() {
        String[] expressionArray = expressionString.split("[+/*-]");

        Expression[] terminals = new Expression[expressionArray.length];
        for (int i = 0; i < expressionArray.length; i++) {
            terminals[i] = new TerminalExpression(Double.parseDouble(expressionArray[i]));
        }

        char[] operators = new char[expressionArray.length - 1];
        int k = 0;
        for (int i = 0; i < expressionString.length(); i++) {
            char x = expressionString.charAt(i);
            if (x == '+' || x == '-' || x == '*' || x == '/')
                operators[k++] = x;
        }

        switch (this.expressionRule) {
            case LEFT_EVALUATION:
                return generateLeftEvaluationExpression(terminals, operators);
            case RIGHT_EVALUATION:
                return generateRightEvaluationExpression(terminals, operators);
            case BODMAS:
                return generateBodmasExpression(terminals, operators);
            default:
                return null;
        }
    }

    private Expression generateBodmasExpression(Expression[] terminals, char[] operators) {
        return null;
    }

    private Expression generateRightEvaluationExpression(Expression[] terminals, char[] operators) {
        Expression result = null;
        int k = 0;
        for (int i = terminals.length - 1; i >= 0; i--) {
            Expression expression = terminals[i];
            if (result == null) {
                result = expression;
                continue;
            }
            char operator = operators[k++];
            result = getExpressionByOperator(expression, result, operator);
        }
        return result;
    }

    private Expression generateLeftEvaluationExpression(Expression[] terminals, char[] operators) {
        Expression result = null;
        int k = 0;
        for (Expression expression : terminals) {
            if (result == null) {
                result = expression;
                continue;
            }
            char operator = operators[k++];
            result = getExpressionByOperator(result, expression, operator);
        }
        return result;
    }

    private Expression getExpressionByOperator(Expression expression1, Expression expression2, char operator) {
        Expression expression = null;
        switch (operator) {
            case '+':
                expression = new PlusExpression(expression1, expression2);
                break;
            case '-':
                expression = new MinusExpression(expression1, expression2);
                break;
            case '*':
                expression = new MultiplyExpression(expression1, expression2);
                break;
            case '/':
                expression = new DivideExpression(expression1, expression2);
                break;
        }
        return expression;
    }
}
