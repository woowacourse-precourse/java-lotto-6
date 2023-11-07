package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {
    public void play() {

    }

    public void start() {
        Money money = new Money();
        int trial = money.trial();
    }
}
