package lotto.domain;

import static lotto.domain.constants.DomainConstants.*;
import static lotto.domain.constants.DomainConstants.LOTTO_PRICE;
import static lotto.domain.constants.ErrorMessageConstants.*;

public class Money {

    private final int money;

    public Money(String userInput) {
        validateUserAmout(userInput);
        this.money = Integer.parseInt(userInput);
    }

    public LottoQuantity generateQuantity() {
        return new LottoQuantity(money / LOTTO_PRICE);
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
                throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
            }
        }
    }

    private void validateAboveOrEqualThousand(String userInput) {
        if (Integer.parseInt(userInput) < LOTTO_PRICE) {
            throw new IllegalArgumentException(ABOVE_THOUSAND_MESSAGE);
        }
    }

    private void validateDivisibleByThousand(String userInput) {
        if ((Integer.parseInt(userInput) % LOTTO_PRICE) != ZERO_CHANGE) {
            throw new IllegalArgumentException(DIVISIBLE_BY_THOUSAND_MESSAGE);
        }
    }
}
