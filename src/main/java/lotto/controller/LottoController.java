package lotto.controller;

import lotto.model.LottosList;
import lotto.view.ConsolePrint;

public class LottoController {
    private LottosList lottosList;

    public void start() {
        new LottosList(ConsolePrint.readPrice());
    }


}
