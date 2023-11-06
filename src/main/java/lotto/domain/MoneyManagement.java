package lotto.domain;

public class MoneyManagement {
    private final int quantity;

    public MoneyManagement(int userInput) {
        validate(userInput);
        quantity = userInput;
    }

    private void validate(int userInput) {
    }
}
