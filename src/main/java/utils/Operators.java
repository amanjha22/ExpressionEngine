package utils;

/**
 * @author Aman
 */
public enum Operators {
    ADDITION(4),
    SUBTRACTION(3),
    DIVISION(1),
    MULTIPLICATION(2),
    COSINE(0),
    SINE(0),
    TAN(0);

    public int priority;

    Operators(int priority){
        this.priority=priority;
    }

    public int getPriority(){
        return this.priority;
    }
}
