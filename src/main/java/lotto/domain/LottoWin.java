package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.ErrorMessage.DUPLICATE_NUMBER_ERROR;
import static lotto.view.ErrorMessage.INVALID_RANGE_ERROR;

public class LottoWin {
    private static final Integer WINNING_LOTTO_SIZE = 7;
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;

    private final Lotto lottoWin;
    private final Integer bonusNumber;

    public LottoWin(List<Integer> lottoWin, Integer bonusNumber) {
        this.lottoWin = new Lotto(lottoWin);
        validateBonusNumber(lottoWin, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonnusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(List<Integer> lottoWin, Integer bonusNumber) {
        validateDuplicate(lottoWin, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicate(List<Integer> lottoWin, Integer number) {
        Set<Integer> nonDuplicateNumber = new HashSet<>(lottoWin);
        nonDuplicateNumber.add(number);
        if (nonDuplicateNumber.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    private void validateRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR);
        }
    }

    public boolean isContain(int number) {
        return lottoWin.isContain(number);
    }
}
