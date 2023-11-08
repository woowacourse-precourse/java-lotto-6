package lotto.model;

import lotto.util.StringUtils;

public class Money {
    private final int amount;

    public Money(String inputMoney) {
        validate(inputMoney);
        this.amount = Integer.parseInt(inputMoney);
    }

    private void validate(String inputMoney) {
        validateNumberFormat(inputMoney);
        validateDivideIntoUnit(inputMoney);
    }

    private void validateNumberFormat(String inputMoney) {
        if (!StringUtils.isNumeric(inputMoney)) {
            throw new IllegalArgumentException(StringUtils.createErrorMessage("숫자만 입력해주세요."));
        }
    }

    private void validateDivideIntoUnit(String inputMoney) {
        if (Integer.parseInt(inputMoney) % Constants.LOTTO_UNIT.constants > 0) {
            throw new IllegalArgumentException(
                    StringUtils.createErrorMessage(Constants.LOTTO_UNIT.constants + " 단위로 입력해주세요."));
        }
    }

    public int getCountByCost(int cost) {
        return amount / cost;
    }

    public double calculateRateOfReturn(long rewardMoney) {
        return ((double) rewardMoney / amount * 100);
    }
}
