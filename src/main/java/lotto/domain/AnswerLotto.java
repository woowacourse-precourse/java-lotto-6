package lotto.domain;

import java.util.List;

public class AnswerLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;


    private AnswerLotto(Lotto lotto) {
        this.lotto = lotto;
        this.bonusNumber = null;
    }

    private AnswerLotto(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.value())) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호가 일치합니다.");
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static AnswerLotto of(List<Integer> numbers) {
        return new AnswerLotto(new Lotto(numbers));
    }

    public AnswerLotto registerBonusNumber(Integer number) {
        return new AnswerLotto(this.lotto, new BonusNumber(number));
    }
}
