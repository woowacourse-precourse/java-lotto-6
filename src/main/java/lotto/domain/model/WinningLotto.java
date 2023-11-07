package lotto.domain.model;

import java.util.List;
import lotto.constant.IllegalArgumentExceptionType;

public final class WinningLotto {
    private final Lotto lotto;
    private final LottoBonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoBonusNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, LottoBonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getValue())) {
            throw IllegalArgumentExceptionType.WINNING_LOTTO_CONTAINS_BONUS_NUMBER.getException();
        }
    }

    private boolean isNumberExistInWinningLotto(int number) {
        return lotto.contains(number);
    }

    public int getMatchCounts(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        long count = numbers.stream().filter(this::isNumberExistInWinningLotto).count();

        return Long.valueOf(count).intValue();
    }

    public boolean isLottoMatchedWithBonusNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int bonusValue = bonusNumber.getValue();
        return numbers.contains(bonusValue);
    }
}
