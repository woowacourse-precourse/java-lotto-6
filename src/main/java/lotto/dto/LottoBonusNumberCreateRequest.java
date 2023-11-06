package lotto.dto;

import lotto.exception.ExceptionMessage;

public class LottoBonusNumberCreateRequest {
    private int bonusNumber;

    public LottoBonusNumberCreateRequest(String bonusNumber) {
        try {
            this.bonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_FORMAT);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
