package lotto.controller;

import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoBuyPrice;
import lotto.domain.LottoWinningNumber;
import lotto.dto.LottoNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.constant.LottoErrorMessage.*;
import static lotto.constant.LottoInputMessage.*;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        LottoBuyPrice lottoBuyPrice = inputLottoBuyPrice();
        List<LottoNumbers> buyLottoNumbers = lottoService.buyLotto(lottoBuyPrice);
        OutputView.printBuyLottoResultMessage(buyLottoNumbers);

        LottoWinningNumber lottoWinningNumber = inputLottoWinningNumber();
        LottoBonusNumber lottoBonusNumber = inputLottoBonusNumber(lottoWinningNumber.getNumbers());
    }

    private LottoBuyPrice inputLottoBuyPrice() {
        try {
            int inputLottoBuyPrice = InputView.inputNumber(INPUT_LOTTO_BUY_PRICE_MESSAGE);

            return new LottoBuyPrice(inputLottoBuyPrice);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(INPUT_LOTTO_BUY_PRICE_ERROR_MESSAGE);

            return inputLottoBuyPrice();
        }
    }

    private LottoWinningNumber inputLottoWinningNumber() {
        try {
            List<Integer> inputLottoWinningNumbers = InputView.inputNumbersWithDelimiter(
                    INPUT_LOTTO_WINNING_NUMBER_MESSAGE,
                    INPUT_LOTTO_WINNING_NUMBER_DELIMITER
            );

            return new LottoWinningNumber(inputLottoWinningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(INPUT_LOTTO_WINNING_NUMBER_ERROR_MESSAGE);

            return inputLottoWinningNumber();
        }
    }

    private LottoBonusNumber inputLottoBonusNumber(List<Integer> excludingNumbers) {
        try {
            int inputLottoBonusNumber = InputView.inputExcludingSpecifiedNumbers(
                    INPUT_LOTTO_BONUS_NUMBER_MESSAGE,
                    excludingNumbers
            );

            return new LottoBonusNumber(inputLottoBonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(INPUT_LOTTO_BONUS_NUMBER_ERROR_MESSAGE);

            return inputLottoBonusNumber(excludingNumbers);
        }
    }
}
