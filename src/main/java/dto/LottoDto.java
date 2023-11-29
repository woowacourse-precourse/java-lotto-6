package dto;

import domain.Lotto;

import java.util.List;

public class LottoDto {
    private final List<Integer> numbers;

    private LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoDto create(List<Integer> numbers) {
        return new LottoDto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
