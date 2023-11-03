package lotto.model.dto;

import java.util.List;

public class LottoResponseDto {
    private final List<Integer> numbers;

    public LottoResponseDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String createLottoMessage() {
        return numbers.toString();
    }
}
