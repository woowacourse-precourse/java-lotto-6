package lotto;

import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumbers {

    private final Lotto winning;
    private final Integer bonus;

    public WinningNumbers(Lotto winning, Integer bonus) {
        this.winning = winning;
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(Integer bonus) {
        if (winning.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_AND_BONUS_DUPLICATED_MESSAGE);
        }
    }

    public Map<Grade, Integer> draw(List<Lotto> tickets) {
        Map<Grade, Integer> winners = new HashMap<>();
        for (Lotto ticket : tickets) {
            Grade grade = ticket.draw(winning, bonus);
            int count = winners.getOrDefault(grade, 0);
            winners.put(grade, count + 1);
        }
        return winners;
    }
}
