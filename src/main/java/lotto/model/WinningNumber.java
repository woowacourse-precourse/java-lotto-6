package lotto.model;

import static lotto.common.exception.WinningNumberErrorMessage.DUPLICATE_WINNING_NUMBER_AND_BONUS;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import lotto.common.exception.WinningNumberException;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        validateDuplicateBonusAndWinning(winningNumbers, bonusNumber);
        this.winningNumbers = Lotto.generateLotto(winningNumbers);
        this.bonusNumber = LottoNumber.generateLottoNumber(bonusNumber);
    }

    public MatchResult matchLotto(Lotto lotto) {
        final AtomicInteger count = new AtomicInteger(0);
        final AtomicBoolean isMatchBonusBall = new AtomicBoolean(false);

        compareLotto(lotto, count, isMatchBonusBall);
        return new MatchResult(count.get(), isMatchBonusBall.get());
    }

    private void compareLotto(Lotto lotto, AtomicInteger count, AtomicBoolean isMatchBonusBall) {
        lotto.compare(lottoNumber -> {
            winningNumbers.compare(winNumber -> {
                if (lottoNumber.equals(winNumber)) {
                    count.incrementAndGet();
                }
            });
            isMatchBonusBall.compareAndSet(false, lottoNumber.equals(bonusNumber));
        });
    }

    private void validateDuplicateBonusAndWinning(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new WinningNumberException(DUPLICATE_WINNING_NUMBER_AND_BONUS);
        }
    }
}
