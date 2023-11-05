package lotto.domain;

import lotto.common.consts.ErrorMessage;
import lotto.view.OutputView;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult compareToLotto(Lotto other) {
        int sameCount = lotto.compareTo(other);
        boolean bonusContains = other.contains(bonusNumber);
        LottoResult lottoResult = new LottoResult(sameCount, bonusContains);
        return lottoResult;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (lotto == null) {
            OutputView.printError(ErrorMessage.NULL_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE);
        }
        if (lotto.contains(bonusNumber)) {
            OutputView.printError(ErrorMessage.LOTTO_CONTAINS_BONUS_ERROR_MESSAGE);
            throw new IllegalArgumentException(ErrorMessage.LOTTO_CONTAINS_BONUS_ERROR_MESSAGE);
        }
    }

}
