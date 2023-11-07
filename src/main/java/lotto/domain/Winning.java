package lotto.domain;

import java.util.List;

public class Winning extends LottoRule{
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

}
