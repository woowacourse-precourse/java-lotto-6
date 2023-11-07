package lotto.controller.outputController;

import lotto.model.lottoResultChecker.Lotto;
import lotto.view.outputView.LottoPrintOutput;

import java.util.List;

public class LottoPrintController {

    private final LottoPrintOutput printOutput = new LottoPrintOutput();

    public void handleLottoDisplay(List<Lotto> lotto) {
        printOutput.displayLottos(lotto);
    }
}