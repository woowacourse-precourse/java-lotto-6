package lotto.domain;

import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.constant.message.ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.constant.message.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

import java.util.List;

public class WinningNumbers {
    private Lotto winningLotto;

    private int bonusNumber;

    public WinningNumbers(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        validateBonusNumber(lotto, bonusNumber);
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        validateNumberBoundary(bonusNumber);
        validateDuplication(lotto, bonusNumber);
    }

    private void validateNumberBoundary(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private void validateDuplication(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR);
        }
    }

    public LottoResult checkLottos(List<Lotto> lottos) {
        LottoResult lottoResult = new LottoResult();
        lottos.forEach(lotto -> lottoResult.addResult(checkLotto(lotto)));
        return lottoResult;
    }

    private Rank checkLotto(Lotto userLotto) {
        return Rank.decideRank(countCollectNumbers(userLotto), checkBonusNumber(userLotto));
    }

    private int countCollectNumbers(Lotto lotto) {
        return (int) this.winningLotto.getNumbers().stream()
                .filter(lotto::hasNumber)
                .count();
    }

    private boolean checkBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }
}
