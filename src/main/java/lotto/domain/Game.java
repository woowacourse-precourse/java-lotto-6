package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Integer> answer;
    private final int bonusNumber;

    public Game(List<Integer> answer, int bonusNumber) {
        validateOverSize(answer);
        validateDuplicateNumber(answer);
        validateDuplicateBonusNumber(answer,bonusNumber);
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }
    private void validateOverSize(List<Integer> answer) {
        if (answer.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicateNumber(List<Integer> answer) {
        if (!answer.equals(answer.stream().distinct().collect(Collectors.toList()))) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicateBonusNumber(List<Integer> answer, int bonusNumber) {
        if (answer.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
