package lotto.controller;

import lotto.model.Lotto;
import lotto.view.LottoPrintOutput;

import java.util.List;

public class LottoPrintController {

    private final LottoPrintOutput printOutput = new LottoPrintOutput();

    public void handleLottoDisplay(List<Lotto> lotto) {
        printOutput.displayLottos(lotto);
    }
}