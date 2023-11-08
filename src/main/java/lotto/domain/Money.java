package lotto.domain;

import static lotto.domain.DomainConstants.LOTTO_PRICE;

public class Money {

    private final int money;

    public Money(String userInput) {
        validateUserAmout(userInput);
        this.money = Integer.parseInt(userInput);
    }

    public int getQuantity() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }

    private void validateUserAmout(String userInput) {
        validateOnlyNumber(userInput);
        validateAboveOrEqualThousand(userInput);
        validateDivisibleByThousand(userInput);
    }

    private void validateOnlyNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if(!Character.isDigit(userInput.charAt(i))){
                throw new IllegalArgumentException(DomainConstants.ONLY_NUMBER_MESSAGE);
            }
        }
    }

    private void validateAboveOrEqualThousand(String userInput) {
        if (Integer.parseInt(userInput) < DomainConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException(DomainConstants.ABOVE_THOUSAND_MESSAGE);
        }
    }

    private void validateDivisibleByThousand(String userInput) {
        if ((Integer.parseInt(userInput) % DomainConstants.LOTTO_PRICE) != DomainConstants.ZERO_CHANGE) {
            throw new IllegalArgumentException(DomainConstants.DIVISIBLE_BY_THOUSAND_MESSAGE);
        }
    }
}
