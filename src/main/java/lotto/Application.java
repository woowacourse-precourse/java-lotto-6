package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.LottoCreator;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.NumberGenerator;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoCreator lottoCreator = new LottoCreator(numberGenerator);
        try {
            LottoGameController lottoGameController = new LottoGameController(lottoCreator, numberGenerator);
            lottoGameController.start();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
