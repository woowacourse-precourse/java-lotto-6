package lotto.domain;

import static lotto.view.ExceptionMessage.NULL_EXCEPTION;
import static lotto.view.ExceptionMessage.RANGE_EXCEPTION;

public class LottoBonusNumber {
    private final Integer lottoBonusNumber;

    public LottoBonusNumber(String readBonusNumber, Lotto lotto) {
        validateBonusNumberNullCheck(readBonusNumber);
        validateBonusNumberRange(readBonusNumber);
        Integer lottoBonusNumber = convertStringToIntegerFormat(readBonusNumber);
        validateWinningNumbersAndBonusNumber(lottoBonusNumber, lotto);
        this.lottoBonusNumber = lottoBonusNumber;
    }

    private void validateBonusNumberNullCheck(String readBonusNumber) {
        if (readBonusNumber == null || "".equals(readBonusNumber)) {
            throw new IllegalArgumentException(NULL_EXCEPTION.getMessage());
        }
    }

    private void validateBonusNumberRange(String readBonusNumber) {
        if (Integer.valueOf(readBonusNumber) < 1 || Integer.valueOf(readBonusNumber) > 45) {
            throw new IllegalArgumentException(RANGE_EXCEPTION.getMessage());
        }
    }

    private void validateWinningNumbersAndBonusNumber(Integer lottoBonusNumber, Lotto lotto) {
        lotto.duplictionLottoBonusNumberAndWinNumber(lottoBonusNumber);
    }


    Integer convertStringToIntegerFormat(String readBonusNumber) {
        return Integer.valueOf(readBonusNumber);
    }

    public Integer getLottoBonusNumber() {
        return lottoBonusNumber;
    }
}
