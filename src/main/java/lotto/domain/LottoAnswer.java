package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoAnswer {

    private List<Integer> answerNumbers = new ArrayList<>();

    public LottoAnswer(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }
}
