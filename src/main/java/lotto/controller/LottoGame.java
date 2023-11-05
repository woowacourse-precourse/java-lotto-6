package lotto.controller;

import lotto.dto.request.LottoMoneyRequest;
import lotto.dto.request.LottoNumberRequest;
import lotto.dto.request.LottoRequest;
import lotto.dto.response.LottoBuyResponse;
import lotto.dto.response.LottoGameResultResponse;
import lotto.service.LottoGameService;
import lotto.view.InputOutputView;

public class LottoGame {
    private final LottoGameService lottoGameService;
    private final InputOutputView inputOutputView;

    public LottoGame(LottoGameService lottoGameService) {
        this.lottoGameService = lottoGameService;
        this.inputOutputView = new InputOutputView();
    }

    public void start() {
        LottoMoneyRequest lottoMoneyRequest = inputOutputView.inputMoney();
        LottoBuyResponse lottoBuyResponse = lottoGameService.buyLottos(lottoMoneyRequest);
        inputOutputView.printBuyLottos(lottoBuyResponse);

        LottoRequest lottoRequest = inputOutputView.inputWinningNumbers();
        LottoNumberRequest bonusLottoNumber = inputOutputView.inputBonusNumber(lottoRequest);
        LottoGameResultResponse lottoGameResultResponse = lottoGameService.calculateResult(lottoRequest,
                bonusLottoNumber);
        inputOutputView.printResult(lottoGameResultResponse);
    }
}
