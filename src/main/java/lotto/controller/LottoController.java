package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.User;
import lotto.ui.InputView;

import java.util.List;

import static lotto.ui.OutputView.outputLottoResult;

public class LottoController {

    private User user;
    private LottoStore lottoStore;
    private LottoController(User user, LottoStore lottoStore) {
        this.user = user;
        this.lottoStore = lottoStore;
        runLottoGame();
    }
    public static LottoController startProgram(){
        return new LottoController(User.buyLotto(),new LottoStore());
    }

    private void runLottoGame(){
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumbers();

        double rateOfReturn = user.calculateRateOfReturn(winningNumbers,bonusNumber);
        int[] lottoResult = user.getLottoResults(winningNumbers,bonusNumber);
        String resultMessage = lottoStore.getLottoResultsSummary(lottoResult, rateOfReturn);
        outputLottoResult(resultMessage);
    }




}


















