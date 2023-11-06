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
        int purchaseAmount = getValidPurchaseAmount();
        int purchaseQuantity = purchaseAmount / LOTTO_PRICE;
        List<Lotto> userLottos = lottoService.purchase(purchaseQuantity);
        OutputView.purchaseResults(userLottos);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = InputView.purchaseAmount();
                Validator.purchaseAmount(inputPurchaseAmount);
                return Integer.parseInt(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e);
            }
        }
    }

    private void lottoGameInit() {
        String[] winningNumbers = getValidWinningNumbers();
        lottoService.initWinningNumbers(winningNumbers);

        int bonusNumber = getValidBonusNumber(winningNumbers);
        lottoService.initBonusNumber(bonusNumber);
    }

    private String[] getValidWinningNumbers() {
        while (true) {
            try {
                String[] inputWinningNumbers = InputView.winningNumbers().split(",");
                Validator.winningNumbers(inputWinningNumbers);
                return inputWinningNumbers;
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e);
            }
        }
    }

    private int getValidBonusNumber(String[] winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = InputView.bonusNumber();
                Validator.bonusNumber(inputBonusNumber,winningNumbers);
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e);
            }
        }
    }

    private void printLottoResults() {
        HashMap<LottoRank, Integer> winningRankCount = lottoService.checkLottoResult();
        double profitRate = lottoService.calculateProfitRate();
        OutputView.lottoResults(winningRankCount,profitRate);
    }
}
