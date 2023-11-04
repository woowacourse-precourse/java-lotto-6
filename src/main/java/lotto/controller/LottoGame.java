package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.dto.LottoBuyResponse;
import lotto.dto.LottoGameResultResponse;
import lotto.service.LottoGameService;
import lotto.view.InputOutputView;

public class LottoGame {
    private LottoGameService lottoGameService;
    private InputOutputView inputOutputView;

    public LottoGame() {
        this.lottoGameService = new LottoGameService();
        this.inputOutputView = new InputOutputView();
    }

    public void start() throws IllegalArgumentException {
        Money money = inputOutputView.inputMoney();
        LottoBuyResponse lottoBuyResponse = lottoGameService.buyLottos(money);
        inputOutputView.printBuyLottos(lottoBuyResponse);

        Lotto winningNumbers = inputOutputView.inputWinningNumbers();
        int bonusNumber = inputOutputView.inputBonusNumber(winningNumbers);

        if (winningNumbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        LottoGameResultResponse result = lottoGameService.calculateResult(winningNumbers, bonusNumber);
        inputOutputView.printResult(result);
    }
}
