package lotto.dto;

import java.util.List;

public record AnswerResponse(
        List<Integer> answerNumbers
) {
    public List<Integer> getResponse() {
        return answerNumbers.stream()
                .sorted()
                .toList();
    }
}
