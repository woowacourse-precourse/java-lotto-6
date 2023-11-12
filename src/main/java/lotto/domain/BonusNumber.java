package lotto.domain;

import static lotto.constant.ErrorMessage.DUPLICATED_BONUS;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    public BonusNumber(int inputBonusNumber, Lotto lottoNumbers) {
        LottoNumber bonusNumber = new LottoNumber(inputBonusNumber);
        validateDuplicateBonusNumber(bonusNumber, lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(LottoNumber bonusNumber,Lotto lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS);
        }
    }

    public boolean isIn(Lotto userLotto) {
        return userLotto.contains(bonusNumber);
    }

}
