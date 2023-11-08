package lotto.domain;

import static lotto.constant.ErrorMessage.DUPLICATED_BONUS;

public class WinningLotto {

    private final Lotto lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lottoNumbers, LottoNumber bonusNumber) {
        validateDuplicateBonusNumber(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(Lotto lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS);
        }
    }

    public int countMatchNumbers(Lotto userLotto) {
        return lottoNumbers.countMatchNumbers(userLotto);
    }

    public boolean hasBonusNumber(Lotto userLotto) {
        return userLotto.contains(bonusNumber);
    }

}
