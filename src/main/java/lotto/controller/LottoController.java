package lotto.controller;

import lotto.domain.LottoBuyPrice;
import lotto.dto.LottoNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.constant.LottoErrorMessage.INPUT_LOTTO_BUY_PRICE_ERROR_MESSAGE;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        LottoBuyPrice lottoBuyPrice = inputLottoBuyPrice();
        List<LottoNumbers> buyLottoNumbers = lottoService.buyLotto(lottoBuyPrice);
        OutputView.printBuyLottoResultMessage(buyLottoNumbers);
    }

    private LottoBuyPrice inputLottoBuyPrice() {
        try {
            int inputLottoBuyPrice = InputView.inputNumber();

            return new LottoBuyPrice(inputLottoBuyPrice);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(INPUT_LOTTO_BUY_PRICE_ERROR_MESSAGE);

            return inputLottoBuyPrice();
        }
    }
}
