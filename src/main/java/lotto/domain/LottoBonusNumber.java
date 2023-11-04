package lotto.domain;

import lotto.util.ErrorMessage;

public class LottoBonusNumber {
    int lottoBonusNumber;

    public int getBonusNumber() {
        return lottoBonusNumber;
    }

    public LottoBonusNumber(String input) {
        this.lottoBonusNumber = StringToInt(input);
        rangeCheck();
    }

    public void rangeCheck() {
        if (lottoBonusNumber < 1 || lottoBonusNumber > 45) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO.getMessage()
                            + ErrorMessage.LOTTO_BONUS_RANGE_ERROR.getMessage());
        }
    }

    public int StringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO.getMessage()
                            + ErrorMessage.LOTTO_BONUS_STRING_ERROR.getMessage());
        }
    }
}
