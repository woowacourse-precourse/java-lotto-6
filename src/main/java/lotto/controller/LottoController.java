package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.User;
import lotto.ui.InputView;

import java.util.List;

import static lotto.ui.OutputView.outputLottoResult;

public class LottoController {

    private final User user;
    private final LottoStore lottoStore;

    private LottoController(User user, LottoStore lottoStore) {
        this.user = user;
        this.lottoStore = lottoStore;
        runLottoGame();
    }

    public static LottoController startProgram() {
        int amount = InputView.inputAmount();
        List<Lotto> lottos = LottoStore.lottoIssuance(amount);
        return new LottoController(new User(amount, lottos), new LottoStore());
    }

    private void runLottoGame() {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumbers();

        String rateOfReturn = user.calculateRateOfReturn(winningNumbers, bonusNumber);
        int[] lottoResult = user.getLottoResults(winningNumbers, bonusNumber);
        String resultMessage = lottoStore.getLottoResultsSummary(lottoResult, rateOfReturn);
        outputLottoResult(resultMessage);
    }


}


















