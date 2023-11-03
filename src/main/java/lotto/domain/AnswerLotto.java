package lotto.domain;

import java.util.List;

public class AnswerLotto {

    private final Lotto answerNumbers;
    private final BonusNumber bonusNumber;

    private AnswerLotto(List<Integer> answerNumbers, int bonusNumber) {
        this.answerNumbers = new Lotto(answerNumbers);
        this.bonusNumber = BonusNumber.of(answerNumbers, bonusNumber);
    }

    public static AnswerLotto of(List<Integer> answerNumbers, int bonusNumber) {
        return new AnswerLotto(answerNumbers, bonusNumber);
    }

    public Lotto getAnswerNumbers() {
        return answerNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
