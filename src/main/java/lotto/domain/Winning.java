package lotto.domain;

import java.util.List;

public class Winning extends LottoRule {
    private List<Integer> numbers;
    private int bonusNumber;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
