package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public final List<Integer> answer;
    public final int bonusNumber;

    public Game(List<Integer> answer, int bonusNumber) {
        validateOverSize(answer);
        validateDuplicateNumber(answer);
        validateDuplicateBonusNumber(answer,bonusNumber);
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }
    private void validateOverSize(List<Integer> answer) {
        if (answer.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리가 넘는 숫자를 입력했습니다.");
        }
    }
    private void validateDuplicateNumber(List<Integer> answer) {
        if (!answer.equals(answer.stream().distinct().collect(Collectors.toList()))) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복됩니다.");
        }
    }

    private void validateDuplicateBonusNumber(List<Integer> answer, int bonusNumber) {
        if (answer.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복됩니다.");
        }
    }
}
