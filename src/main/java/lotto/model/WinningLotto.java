package lotto.model;

import lotto.constant.ErrorMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (bonus.hasBonusNumber(lotto)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.getMessage());
        }
    }

    //TODO: 씁 from 인데 다른 타입을 반환하는것도 괜찮은건가?
    // 객체가 서로 협력하는 느낌이 있긴하다..ㅎㅎ
    public LottoPrize compare(Lotto boughtLotto) {
        return LottoPrize.from(lotto.count(boughtLotto), bonus.hasBonusNumber(boughtLotto));
    }
}
