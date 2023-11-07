package lotto.controller;

import lotto.domain.NumberGenerator;

public class LottoController {
    private final NumberGenerator numberGenerator;

    public LottoController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
    }
}
