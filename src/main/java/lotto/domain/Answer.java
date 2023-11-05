package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Answer {
    private final List<Integer> answer;
    private final int bonusNumber;

    public Answer(List<String> answer, int bonusNumber) {
        this.answer = answer.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }
}
