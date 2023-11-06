package lotto.domain;

import java.util.List;
import lotto.dto.AnswerResponse;

public class Answer {
    private final List<Integer> answerNumbers;

    private Answer(final List<Integer> input) {
        this.answerNumbers = input;
    }

    public static Answer create(final List<Integer> input) {
        return new Answer(input);
    }

    public AnswerResponse generateAnswerResponse() {
        return new AnswerResponse(answerNumbers);
    }
}
