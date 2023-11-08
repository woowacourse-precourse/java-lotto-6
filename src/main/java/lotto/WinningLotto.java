package lotto;

import static lotto.constant.ErrorMessage.DUPLICATED_BONUS;

import java.util.List;

public class WinningLotto {

    private final Lotto lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        validateDuplicateBonusNumber(lottoNumbers, bonusNumber);
        this.lottoNumbers = new Lotto(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validateDuplicateBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
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
