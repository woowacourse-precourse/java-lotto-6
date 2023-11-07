package lotto.domain;

import lotto.constants.ErrorMessage;

public class PurchaseAmount {
    public static final int PRICE_PER_ONE_LOTTO = 1000;
    public static final String COMMA = ",";
    public static final String NULL = "";
    public static final int PURCHASE_AMOUNT_RANGE_MIN = 0;

    private int amount;
    private int numberOfLotto;

    public PurchaseAmount(String amount) {
        amount = removeSeparator(amount);
        validate(amount);
        this.amount = convertStringToInt(amount);
        this.numberOfLotto = this.amount / PRICE_PER_ONE_LOTTO;
    }
    
    private void validate(String amount) {
        if(isNull(amount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NULL_INPUT.getMessage());
        }
        if(!isInRange(amount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ZERO.getMessage());
        }
        if(!isDigit(amount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_DIGIT.getMessage());
        }
        if(!isCorrectUnit(amount)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_WRONG_UNIT_INPUT.getMessage());
        }
    }

    private String removeSeparator(String amount) {
        return amount.replaceAll(COMMA, NULL);
    }

    private boolean isNull(String amount) {
        return amount==null || amount.isEmpty() || amount.isBlank();
    }

    private boolean isCorrectUnit(String amount) {
        return (convertStringToInt(amount) % PRICE_PER_ONE_LOTTO) == 0;
    }

    private boolean isDigit(String amount) {
        return amount.chars().allMatch(Character::isDigit);
    }

    private boolean isInRange(String amount) {
        return convertStringToInt(amount) > PURCHASE_AMOUNT_RANGE_MIN;
    }
    private int convertStringToInt(String amount) {
        return Integer.parseInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }
}
