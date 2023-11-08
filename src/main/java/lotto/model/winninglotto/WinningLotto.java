package lotto.model.winninglotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoRanking;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;
    private final HitCounter hitCounter;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
        this.hitCounter = createHitCounter(winningLotto, bonusLottoNumber);
    }

    public static WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberNotDuplicated(winningNumbers, bonusNumber);
        Lotto winningLotto = Lotto.issueChooseNumbersLotto(winningNumbers);
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        return new WinningLotto(winningLotto, bonusLottoNumber);
    }

    public LottoRanking checkRanking(Set<LottoNumber> lottoNumbers) {
        Set<Integer> numbers = lottoNumbers.stream()
            .map(LottoNumber::number)
            .collect(Collectors.toSet());
        return hitCounter.countHit(numbers);
    }

    private static void validateBonusNumberNotDuplicated(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private HitCounter createHitCounter(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        Set<Integer> winningNumbers = winningLotto.getLottoNumbers()
            .stream()
            .map(LottoNumber::number)
            .collect(Collectors.toSet());

        return new HitCounter(winningNumbers, bonusLottoNumber.number());
    }
}
