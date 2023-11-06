package lotto.domain;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoBonusNumber {
    private final int lottoBonusNumber;

    public LottoBonusNumber(String input, List<Integer> LottoWinNumbers) {
        this.lottoBonusNumber = StringToInt(input);
        uniqueCheck(LottoWinNumbers);
        rangeCheck();
    }

    private void uniqueCheck(List<Integer> LottoWinNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(LottoWinNumbers);
        if (uniqueNumbers.contains(lottoBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_UNIQUE_ERROR);
        }
    }

    private void rangeCheck() {
        if (lottoBonusNumber < Constants.LOTTO_MIN_NUM || lottoBonusNumber > Constants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_RANGE_ERROR);
        }
    }

    private int StringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_STRING_ERROR);
        }
    }

    public int getBonusNumber() {
        return lottoBonusNumber;
    }
}
