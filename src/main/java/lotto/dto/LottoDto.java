package lotto.dto;

import lotto.vo.Number;

import java.util.List;

public class LottoDto {
    private List<Number> numbers;

    public LottoDto(List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
