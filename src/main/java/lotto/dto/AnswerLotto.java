package lotto.dto;

import java.util.List;

public class AnswerLotto {

    private List<Integer> answerNumbers;
    private int bonusNumber;

    public AnswerLotto(List<Integer> answerNumbers, int bonusNumber) {
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
