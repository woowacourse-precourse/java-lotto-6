package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Answer {
    private final HitNumbers hitNumbers;
    private final int bonusNumber;

    public Answer(HitNumbers hitNumbers, int bonusNumber) {
        this.hitNumbers = hitNumbers;
        this.bonusNumber = bonusNumber;
    }
}
