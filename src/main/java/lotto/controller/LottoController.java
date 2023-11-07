package lotto.controller;

import lotto.domain.Lotto;

import java.util.List;

public class LottoController {
    public Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

}
