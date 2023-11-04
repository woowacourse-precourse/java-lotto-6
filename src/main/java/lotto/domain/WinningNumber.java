package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningNumber {
    private Lotto lottoNumber;
    private BonusNumber bonusNumber;

    public WinningNumber(Lotto lottoNumber, BonusNumber bonusNumber) {
        validateLottoNumberContainBonusNumber(lottoNumber, bonusNumber);
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }


    private void validateLottoNumberContainBonusNumber(Lotto lottoNumber, BonusNumber bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) throw new IllegalArgumentException("보너스 번호가 당첨 번호 6개 중에 포함되어있습니다.");
    }
}
