package lotto.domain;

import java.util.List;

public class NumberMatcher {
    private final List<Integer> answerNumbers;

    private NumberMatcher(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public static NumberMatcher from(List<Integer> answerNumbers) {
        return new NumberMatcher(answerNumbers);
    }
}