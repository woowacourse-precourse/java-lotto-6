package lotto.lotto;

import java.util.Collections;
import java.util.List;

final class LottoAnswer {
    private final List<Integer> answer;
    private final int bonus;

    LottoAnswer(List<Integer> answer, int bonus) {
        this.answer = Collections.unmodifiableList(answer);
        this.bonus = bonus;
    }

    boolean containAnswer(int number) {
        return answer.contains(number);
    }

    boolean containBonus(List<Integer> numbers) {
        return numbers.contains(bonus);
    }
}
