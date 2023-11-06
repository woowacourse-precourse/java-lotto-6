package lotto.domain.dto;

import lotto.domain.Lotto;

import java.util.List;

public record LottoAnswer(Lotto lotto, int bonus) {
    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}
