package lotto.controller;

import static lotto.Message.ErrorMessage.VALUE_IS_NOT_CONVERT_INTEGER;
import lotto.config.WinningResultConfig;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.LottoService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private PurchaseAmount purchaseAmount;
    private UserLotto userLotto;
    private Lotto lotto;
    private BonusLotto bonusLotto;
    private LottoService lottoService;
    private LinkedHashMap<WinningResultConfig, Integer> lottoResults;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
            runInputPurchaseAmount();
            runPrintLottoQuantity();
            runPrintUserLottoNumbers();
            runInputWinningNumbers();
            runInputBonusNumber();
            runFindWinningResult();
            runFindTotalRevenue();
    }

    private void runInputPurchaseAmount() {
        try {
            outputView.printPurchaseAmountMessage();
            purchaseAmount = new PurchaseAmount(Integer.parseInt(inputView.input()));
        } catch (NumberFormatException e) {
            outputView.printException(VALUE_IS_NOT_CONVERT_INTEGER.getMessage());
            runInputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            runInputPurchaseAmount();
        }
    }

    private void runPrintLottoQuantity() {
        outputView.printQuantityOfPurchase(purchaseAmount.getLottoQuantity());
    }

    private void runPrintUserLottoNumbers() {
        userLotto = new UserLotto(purchaseAmount.getLottoQuantity());
        outputView.printUserLottoNumber(userLotto.getUserLottoNumbers());

    }

    private void runInputWinningNumbers() {
        try {
            outputView.printWinningNumberMessage();
            lotto = new Lotto(inputView.input());
        } catch (NumberFormatException e) {
            outputView.printException(e.getMessage());
            runInputWinningNumbers();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            runInputWinningNumbers();
        }
    }

    private void runInputBonusNumber() {
        try {
            outputView.printBonusNumberMessage();
            bonusLotto = new BonusLotto(Integer.parseInt(inputView.input()), lotto.getWinningNumbers());
        } catch (NumberFormatException e) {
            outputView.printException(VALUE_IS_NOT_CONVERT_INTEGER.getMessage());
            runInputBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            runInputBonusNumber();
        } catch (NullPointerException e) {
            outputView.printException(e.getMessage());
            runInputBonusNumber();
        }
    }

    private void runFindWinningResult() {
        outputView.printWinningResultMessage();
        outputView.printLineSymbol();

        try {
            lottoService = new LottoService(userLotto.getUserLottoNumbers(), lotto.getWinningNumbers(), bonusLotto.getBonusNumber());
            lottoResults = lottoService.findWinningResult();

            for (Map.Entry<WinningResultConfig, Integer> lottoResult : lottoResults.entrySet()) {
                if (lottoResult.getKey().getResultStatus().contains("보너스 볼")) {
                    outputView.printWinningBonusResult(lottoResult.getKey().getResultStatus().split(",")[0],
                            lottoResult.getKey().getResultStatus().split(",")[1],
                            lottoResult.getKey().getRevenueStatus(),
                            lottoResult.getValue());
                    continue;
                }
                outputView.printWinningResult(lottoResult.getKey(),lottoResult.getValue());
            }
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    private void runFindTotalRevenue() {
        try {
            List<List<Integer>> winningResultSources = new ArrayList<>();

            for (Map.Entry<WinningResultConfig, Integer> entry : lottoResults.entrySet()) {
                winningResultSources.add(Arrays.asList(entry.getKey().getRevenueStatus(), entry.getValue()));
            }

            outputView.printTotalRevenue(new Revenue(winningResultSources, purchaseAmount.getPurchaseAmount()).getRevenue());
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
    }
}
