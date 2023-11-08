package lotto.domain.lotto;

import java.util.List;
import lotto.domain.lotto.boxed.BonusNumber;
import lotto.domain.lotto.validator.LottoValidator;

public final class WinningLotto extends Lotto {

    /**
     * 당첨 로또 번호 외 보너스 번호
     */
    private final BonusNumber bonusNumber;

    /**
     * @apiNote Lotto 생성 시, <h3 color="#bf0f4d">numbers의 요소는 반드시 1~45 범위에 속하는 6개의 숫자여야 합니다.</h3>
     */
    public WinningLotto(
            final List<Integer> winningNumbers,
            final int bonusNumber
    ) {
        super(winningNumbers);
        LottoValidator.validateDuplicationWithBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    /**
     * 로또 한 장을 추첨하여 등수, 당첨금 등의 데이터가 담긴 `LottoPrize` 반환
     */
    public LottoPrize draw(final Lotto lotto) {
        final int matchedCount = countMatchedNumbers(lotto);
        final boolean hasBonusNumber = lotto.numbers.contains(bonusNumber);
        return LottoPrize.of(matchedCount, hasBonusNumber);
    }

    /**
     * 몇 개의 번호가 일치하는지 개수 반환
     */
    private int countMatchedNumbers(final Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

}
