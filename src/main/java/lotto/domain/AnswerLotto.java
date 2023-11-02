package lotto.domain;

import java.util.List;

public class AnswerLotto {

    private List<Integer> answerNumbers;
    private int bonusNumber;

    public AnswerLotto(List<Integer> answerNumbers, int bonusNumber) {
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    
}
