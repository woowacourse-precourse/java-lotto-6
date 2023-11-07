package lotto.domain;

import java.util.List;

public class Jackpot extends Lotto{

    private int bonus;

    public Jackpot(List<Integer> numbers, int bonus) {
        super(numbers);
        manageException(numbers, bonus);
        this.bonus = bonus;
    }

    private void manageException(List<Integer> numbers, int bonus) {
        validateDuplicationOfBonus(numbers, bonus);
    }

    private void validateDuplicationOfBonus(List<Integer> numbers, int bonus) {
        numbers.add(bonus);

        super.validateDuplication(numbers);
    }
}
