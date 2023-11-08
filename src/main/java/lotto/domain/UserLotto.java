package lotto.domain;

import java.util.List;

public class UserLotto {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public UserLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
