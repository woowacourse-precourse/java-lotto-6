package lotto.controller.dto;

import java.util.Collections;
import java.util.List;
import lotto.model.Number;

public class LottoResponse {

    private final List<Integer> lotto;

    private LottoResponse(final List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static LottoResponse from(final List<Number> numbers) {
        return new LottoResponse(convertFrom(numbers));
    }

    private static List<Integer> convertFrom(final List<Number> numbers) {
        return numbers.stream()
                .map(Number::getNumber)
                .toList();
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
