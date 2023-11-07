package lotto;

import java.lang.invoke.VarHandle;
import java.util.*;

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
            Optional<Grade> optionalGrade = ticket.draw(winning, bonus);
            if (optionalGrade.isPresent()) {
                Grade grade = optionalGrade.get();
                int numOfWinners = winners.getOrDefault(grade, 0);
                winners.put(grade, numOfWinners + 1);
            }
        }
        return winners;
    }
}
