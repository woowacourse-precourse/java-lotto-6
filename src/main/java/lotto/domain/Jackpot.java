package lotto.domain;

import java.util.List;

public class Jackpot extends Lotto{

    private int bonus;

    public Jackpot(List<Integer> numbers, int bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    public Jackpot create(List<Integer> numbers, int bonus) {
        manageException(numbers, bonus);

        return new Jackpot(numbers, bonus);
    }

    private void manageException(List<Integer> numbers, int bonus) {
        validateDuplicationOfBonus(numbers, bonus);
    }

    private void validateDuplicationOfBonus(List<Integer> numbers, int bonus) {
        numbers.add(bonus);

        super.validateDuplication(numbers);
    }
}
