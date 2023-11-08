package lotto.lotto.dto;

import java.util.List;

public class LottoDto {

    private List<Integer> numbers;

    public LottoDto() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
