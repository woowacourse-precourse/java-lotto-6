package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoResponse {
    private final List<Integer> numbers;

    private LottoResponse(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<LottoResponse> of(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(LottoResponse::of)
                .toList();
    }

    private static LottoResponse of(Lotto lotto) {
        return new LottoResponse(lotto.getNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return numbers.stream().sorted().toList();
    }
}