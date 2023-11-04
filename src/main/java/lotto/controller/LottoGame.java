package lotto.controller;

import java.util.Map;
import lotto.common.LottoRank;
import lotto.dto.LottoGameResponse;
import lotto.service.LottoGameService;
import lotto.view.InputOutputView;

public class LottoGame {
    private LottoGameService lottoGameService;
    private InputOutputView inputOutputView;

    public LottoGame() {
        this.lottoGameService = new LottoGameService();
        this.inputOutputView = new InputOutputView();
    }

    public void start() {
        int money = inputOutputView.inputMoney();
        LottoGameResponse lottoGameResponse = lottoGameService.buy(money);

        inputOutputView.printBuyLottos(lottoGameResponse);
        String winningNumbers = inputOutputView.inputWinningNumbers();
        int bonusNumber = inputOutputView.inputBonusNumber();

        Map<LottoRank, Integer> result = lottoGameService.calculateResult(winningNumbers, bonusNumber);
        inputOutputView.printResult(result);
    }
}
