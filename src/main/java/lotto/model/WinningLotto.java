package lotto.model;

import static lotto.constants.ErrorMessage.ALREADY_USED_NUMBER_NOT_ALLOWED;
import static lotto.constants.ErrorMessage.LOTTO_RANGE_NUMBER_ALLOWED;
import static lotto.constants.LottoNumber.LOTTO_MIN_NUMBER;
import static lotto.constants.LottoNumber.LOTTO_MAX_NUMBER;

public class WinningLotto {

    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Boolean isDrawnLotto(Lotto userLotto) {
        Integer countMatchNumber = userLotto.countMatchNumber(lotto);
        return countMatchNumber >= 3;
    }

    public LottoPrize findLottoPrizeType(Lotto userLotto) {
        Boolean hasBonusNumber = userLotto.hasNumber(bonusNumber);
        Integer countMatchNumber = userLotto.countMatchNumber(lotto);
        return LottoPrize.valueOf(hasBonusNumber, countMatchNumber);
    }

    private void validate(Integer bonusNumber) {
        validateNumberRange(bonusNumber);
        validateNumberAlreadyUsed(bonusNumber);
    }

    private void validateNumberRange(Integer bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_RANGE_NUMBER_ALLOWED.toString());
        }
    }

    private void validateNumberAlreadyUsed(Integer bonusNumber) {
        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(ALREADY_USED_NUMBER_NOT_ALLOWED.toString());
        }
    }

}
