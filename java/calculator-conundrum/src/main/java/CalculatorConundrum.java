import java.util.List;

class CalculatorConundrum {

    private final static String RESULT_FORMAT = "%d %s %d = %d";

    public String calculate(int operand1, int operand2, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");  
        } else if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");  
        }
        
        int result = switch (operation) {
            case "+" -> result = operand1 + operand2;
            case "*" -> result = operand1 * operand2;
            case "/" -> {
                try {
                    yield result = operand1 / operand2;    
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);  
                }
            }
            default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        };

        return RESULT_FORMAT.formatted(operand1, operation, operand2, result);
    }
}
