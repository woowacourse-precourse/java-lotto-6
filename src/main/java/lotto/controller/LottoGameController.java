package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.HashMap;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class LottoGameController {

    private final LottoService lottoService;

    public LottoGameController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        lottoPurchase();
        lottoGameInit();
        printLottoResults();
    }

    private void lottoPurchase() {
        String inputPurchaseAmount = getValidInputPurchaseAmount();
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        int quantity = purchaseAmount / LOTTO_PRICE;
        List<Lotto> userLottos = lottoService.purchase(quantity);
        OutputView.purchaseQuantityAndLottoNumbers(userLottos);
    }

    private String getValidInputPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = InputView.purchaseAmount();
                Validator.purchaseAmount(inputPurchaseAmount);
                return inputPurchaseAmount;
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e);
            }
        }
    }

    private void lottoGameInit() {
        String inputWinningNumbers = getValidInputWinningNumbers();
        String[] winningNumbers = inputWinningNumbers.split(",");
        lottoService.initWinningNumbers(winningNumbers);
        String inputBonusNumber = getValidInputBonusNumber(winningNumbers);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        lottoService.initBonusNumber(bonusNumber);
    }

    private String getValidInputBonusNumber(String[] winningNumbers) {
        while (true) {
            String inputBonusNumber = InputView.bonusNumber();
            try {
                Validator.inputBonusNumber(inputBonusNumber,winningNumbers);
                return inputBonusNumber;
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e);
            }
        }
    }

    private String getValidInputWinningNumbers() {
        while (true) {
            String inputWinningNumbers = InputView.winningNumbers();
            try {
                Validator.inputWinningNumbers(inputWinningNumbers);
                return inputWinningNumbers;
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e);
            }
        }
    }

    private void printLottoResults() {
        HashMap<LottoRank, Integer> winningRankCount = lottoService.checkLottoResult();
        double profitRate = lottoService.calculateProfitRate();
        OutputView.winningResult(winningRankCount,profitRate);
    }
}
