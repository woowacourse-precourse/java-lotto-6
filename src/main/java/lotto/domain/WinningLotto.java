package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoRank;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateInitialized();

        lotto.validateNumberRange(bonusNumber);
        validateUniqueNumber(bonusNumber);
    }

    private void validateInitialized() {
        if (bonusNumber != 0) {
            throw new IllegalStateException(ErrorMessage.BONUS_NUMBER_ALREADY_INITIALIZED.getMessage());
        }
    }

    private void validateUniqueNumber(int bonusNumber) {
        if (lotto.containNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public LottoRank calculateRank(Lotto lotto) {
        return LottoRank.OUT_RANK;
    }
}
