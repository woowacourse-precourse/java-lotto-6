package lotto.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        validateDuplicateBonusAndWinning(winningNumbers, bonusNumber);
        this.winningNumbers = Lotto.generateLotto(winningNumbers);
        this.bonusNumber = LottoNumber.generateLottoNumber(bonusNumber);
    }

    public int countMatchingNumbers(Lotto lotto) {
        final AtomicInteger count = new AtomicInteger(0);
        lotto.compare(lottoNumber -> {
            winningNumbers.compare(winNumber -> {
                if(lottoNumber.equals(winNumber)) {
                    count.incrementAndGet();
                }
            });
            if(lottoNumber.equals(bonusNumber)) {
                count.incrementAndGet();
            }
        });
        return count.get();
    }

    private void validateDuplicateBonusAndWinning(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
