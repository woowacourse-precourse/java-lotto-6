package lotto.domain;

import java.util.Collections;
import java.util.List;

public class NumberMatcher {
    private final List<Integer> answerNumbers;
    private int bonusNumber;

    private NumberMatcher(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public static NumberMatcher from(List<Integer> answerNumbers) {
        return new NumberMatcher(answerNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAnswerNumbers() {
        return Collections.unmodifiableList(answerNumbers);
    }
}