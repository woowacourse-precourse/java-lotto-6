package lotto.model.dto;

import java.util.List;

public record LottoResponse(List<String> numbers) {

    public static LottoResponse from(final List<Integer> numbers) {
        List<String> numberAnswers = numbers.stream()
                .map(String::valueOf)
                .toList();
        return new LottoResponse(numberAnswers);
    }
}
