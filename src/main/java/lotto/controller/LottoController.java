package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottosList;
import lotto.view.ConsolePrint;

public class LottoController {
    private LottosList lottosList;
    private Lotto winningNumber;

    public void start() {
        lottosList = new LottosList(ConsolePrint.readPrice());
        winningNumber = new Lotto(
                ConsolePrint.readWinningNum().split(","));

    }


}
