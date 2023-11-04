package lotto.domain;

import lotto.exception.ExceptionMessage;

public class LottoWithBonus {
    private final Lotto lotto;
    private final Bonus bonus;

    private LottoWithBonus(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static LottoWithBonus of(Lotto lotto, Bonus bonus) {
        return new LottoWithBonus(lotto, bonus);
    }

    private void validate(Lotto lotto, Bonus bonus) {
        // 중복된 숫자가 존재하는지 확인한다
        if (lotto.getLotto()
                .stream()
                .filter(lottoNumber -> lottoNumber == bonus.getBonusNumber())
                .findFirst()
                .isPresent()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getErrorDescription());
        }
    }

}
