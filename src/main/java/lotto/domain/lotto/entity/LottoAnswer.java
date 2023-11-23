package lotto.domain.lotto.entity;

import lotto.exception.LottoException;

public class LottoAnswer {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public LottoAnswer(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
        validate();
    }

    //로또 정답 비교는 정답 객체에게 로또를 전달?
    //로또 객체에게 정답을 전달??
    //비교 enum을 만들어 정답과 로또를 둘 다 전달?
    private void validate() {
        if (this.lotto.hasNumber(this.bonusNumber)) {
            throw LottoException.LOTTO_DUPLICATED_BONUS_NUMBER.makeException();
        }
    }

    public int getSameNumberCount(Lotto lotto) {
        return lotto.getSameNumberCount(this.lotto);
    }

    public boolean matchesBonusNumber(Lotto lotto) {
        return lotto.hasNumber(this.bonusNumber);
    }
}
