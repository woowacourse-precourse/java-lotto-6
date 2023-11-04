package lotto.controller.dto;

import java.util.Collections;
import java.util.List;
import lotto.model.Number;

public class LottoResult {

    private final List<Integer> lotto;

    private LottoResult(final List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static LottoResult from(final List<Number> numbers) {
        List<Integer> lotto = numbers.stream()
                .map(Number::getValue)
                .toList();
        return new LottoResult(lotto);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
