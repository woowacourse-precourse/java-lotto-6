package lotto.domain;

import lotto.common.consts.ErrorMessage;
import lotto.common.consts.SystemConsts;
import lotto.view.OutputView;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoScore calculateLottoScore(Lotto other) {
        int sameCount = lotto.compareTo(other);
        boolean bonusContains = false;
        if (sameCount == SystemConsts.LOTTO_SECOND_SAME_COUNT) {
            bonusContains = other.contains(bonusNumber);
        }
        LottoScore lottoScore = new LottoScore(sameCount, bonusContains);
        return lottoScore;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (lotto == null) {
            OutputView.printError(ErrorMessage.NULL_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE);
        }
        if (bonusNumber < SystemConsts.RANDOM_RNAGE_START || bonusNumber > SystemConsts.RANDOM_RNAGE_END) {
            OutputView.printError(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER_ERROR_MESSAGE);
        }
        if (lotto.contains(bonusNumber)) {
            OutputView.printError(ErrorMessage.LOTTO_CONTAINS_BONUS_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.LOTTO_CONTAINS_BONUS_ERROR_MESSAGE);
        }
    }

}
