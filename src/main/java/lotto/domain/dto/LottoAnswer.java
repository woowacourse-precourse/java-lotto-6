package lotto.domain.dto;

import java.util.List;

public record LottoAnswer(LottoNumbers lotto, int bonus) {
    public List<Integer> numbers() {
        return lotto.numbers();
    }
}
