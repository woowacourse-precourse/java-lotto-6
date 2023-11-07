package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Win {

    private final List<Integer> numbers;
    private int bonusNumber;

    public Win(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
