package lotto.domain.lotto;

import java.util.List;

public class WinningLotto {

    private static final String DUPLICATES_BONUS_NUMBER = "[ERROR] 당첨 번호와 중복된 보너스 번호를 입력할 수 없습니다.";
    private static final String OUT_OF_RANGE_NUMBER = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.";

    private final Lotto lotto;
    private final int bonusNumber;

    private WinningLotto(final Lotto lotto, final int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto createFrom(final List<Integer> winningNumbers, final int bonusNumber) {
        Lotto lotto = Lotto.createFrom(winningNumbers);
        validateBonusNumber(lotto, bonusNumber);
        return new WinningLotto(lotto, bonusNumber);
    }

    // TODO 분리
    private static void validateBonusNumber(final Lotto lotto, final int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicates(lotto, bonusNumber);
    }

    private static void validateRange(final int bonusNumber) {
        if (LottoCondition.isNotInRange(bonusNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
        }
    }

    private static void validateDuplicates(final Lotto lotto, final int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATES_BONUS_NUMBER);
        }
    }

    public LottoRewardCondition getCompareResult(final Lotto compareLotto) {
        int sameNumberCount = lotto.extractSameCount(compareLotto);
        boolean hasBonusNumber = compareLotto.contains(bonusNumber);
        return LottoRewardCondition.findLottoReward(sameNumberCount, hasBonusNumber);
    }

}
