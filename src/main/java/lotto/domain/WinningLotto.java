package lotto.domain;

import lotto.enums.LottoNumbers;

public class WinningLotto {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        if (bonusNumber < LottoNumbers.MIN_RANGE.getNumber() || bonusNumber > LottoNumbers.MAX_RANGE.getNumber()) {
            throw new IllegalArgumentException("[Error] 보너스 번호의 범위는 1~45 입니다.");
        }
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 로또 번호와 중복 불가 입니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
