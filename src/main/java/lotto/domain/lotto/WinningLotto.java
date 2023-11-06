package lotto.domain;

import lotto.exception.BonusNumDuplicateException;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;


    private WinningLotto(Lotto lotto, LottoNumber bonusNumber){
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static void validate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.containBonusNum(bonusNumber)) {
            throw new BonusNumDuplicateException();
        }
    }

    public boolean contains(LottoNumber lottoNum){
        return lotto.contains(lottoNum);
    }

    public LottoNumber getBonusNumber(){
        return bonusNumber;
    }
}
