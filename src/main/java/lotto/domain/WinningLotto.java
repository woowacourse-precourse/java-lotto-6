package lotto.domain;

import lotto.constant.ErrorMessage;
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
        if (isInitializedBonusNumber()) {
            throw new IllegalStateException(ErrorMessage.BONUS_NUMBER_ALREADY_INITIALIZED.getMessage());
        }
    }

    private boolean isInitializedBonusNumber() {
        return bonusNumber != 0;
    }

    private void validateUniqueNumber(int bonusNumber) {
        if (lotto.containNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public Rank calculateRank(Lotto comparedLotto) {
        if(!isInitializedBonusNumber()) {
            throw new IllegalStateException(ErrorMessage.BONUS_NUMBER_NOT_INITIALIZED.getMessage());
        }

        int matchedNumberCount = lotto.countMatchedNumber(comparedLotto);
        boolean bonusNumberMatched = comparedLotto.containNumber(bonusNumber);

        return Rank.findByMatchedNumberCountAndBonusNumberMatched(matchedNumberCount, bonusNumberMatched);
    }
}