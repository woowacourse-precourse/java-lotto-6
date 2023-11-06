package lotto.dto;

import lotto.Lotto;

import java.util.List;

public record LottoDTO(List<Integer> numbers) {
    public LottoDTO(Lotto lottos) {
        this(lottos.getNumbers());
    }
}