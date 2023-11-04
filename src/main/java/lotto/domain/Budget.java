package lotto.domain;

public class Budget {
    private final int budget;
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "";

    private Budget(int budget){
        this.budget = budget;
    }

    public static Budget from(String inputBudget){
        validateNumeric(inputBudget);
        int budget = Integer.parseInt(inputBudget);
        return new Budget(budget);
    }

    private static void validateNumeric(String inputBudget){
        try{
            Integer.parseInt(inputBudget);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
