package lotto.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class LottoDto {

    private final List<Integer> numbers;

    private LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoDto from(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .toList();
        return new LottoDto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
