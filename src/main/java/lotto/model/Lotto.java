package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int bonus;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void Bonus(int number) {
        this.bonus = number;
    }
    private List<Integer> getLotto() {
        return numbers;
    }
    private int getBonus() {
        return bonus;
    }



}
