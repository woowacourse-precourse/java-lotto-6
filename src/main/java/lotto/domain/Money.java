package lotto.domain;

import lotto.util.CommonInputValidator;

public class Money {
    public static final Integer MONEY_UNIT = 1000;
    private static final Integer MINIMUM_MONEY_STANDARD = 0;
    private static final String IS_THOUSAND_UNIT_VALIDATOR_ERROR_MESSAGE = "[ERROR] 입력 금액은 1,000원 단위여야 합니다.";
    private static final String IS_MINIMUM_VALIDATOR_ERROR_MESSAGE = "[ERROR] 입력 금액은 최소 0원보다 커야 합니다.";
    private final Integer amount;
    public Money(Integer amount){
        isMinimumValidator(amount);
        isThousandUnitValidator(amount);
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    private void isMinimumValidator(Integer money){
        if(money <= MINIMUM_MONEY_STANDARD){
            throw new IllegalArgumentException(IS_MINIMUM_VALIDATOR_ERROR_MESSAGE);
        }
    }
    private void isThousandUnitValidator(Integer money){
        if(money % MONEY_UNIT != 0){
            throw new IllegalArgumentException(IS_THOUSAND_UNIT_VALIDATOR_ERROR_MESSAGE);
        }
    }
}
