package lotto.domain;

import java.util.List;
import lotto.dto.AnswerResponse;
import lotto.parser.Parser;

public class Answer {
    private final List<Integer> answerNumbers;

    private Answer(final String input) {
        this.answerNumbers = Parser.parseLotto(input);
    }

    public static Answer create(final String input) {
        return new Answer(input);
    }

    public AnswerResponse generateAnswerResponse() {
        return new AnswerResponse(answerNumbers);
    }
}
