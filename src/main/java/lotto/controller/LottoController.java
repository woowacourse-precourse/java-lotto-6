package lotto.controller;

import lotto.config.WinningResultConfig;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.Message.ErrorMessage.VALUE_IS_NOT_CONVERT_INTEGER;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private Amount amount;
    private UserLotto userLotto;
    private Lotto lotto;
    private BonusLotto bonusLotto;
    private LottoService lottoService;
    private Map<WinningResultConfig, Integer> lottoResults;
    private Revenue revenue;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            runInputPurchaseAmount();
            runPrintLottoQuantity();
            runPrintUserLottoNumbers();
            runInputWinningNumbers();
            runInputBonusNumber();
            runPrintWinningResult();
            runPrintTotalRevenue();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(VALUE_IS_NOT_CONVERT_INTEGER.getMessage());
        }
    }

    private void runInputPurchaseAmount() {
        outputView.printPurchaseAmountMessage();
        amount = new Amount(Integer.parseInt(inputView.input()));
    }

    private void runPrintLottoQuantity() {
        outputView.printNumberOfPurchase(amount.getLottoQuantity());
    }

    private void runPrintUserLottoNumbers() {
        userLotto = new UserLotto(amount.getLottoQuantity());
        outputView.printUserNumberOfLotto(userLotto.getUserNumbers());
    }

    private void runInputWinningNumbers() {
        outputView.printWinningNumbersMessage();
        lotto = new Lotto(inputView.input());
    }

    private void runInputBonusNumber() {
        outputView.printBonusNumberMessage();
        bonusLotto = new BonusLotto(Integer.parseInt(inputView.input()), lotto.getNumbers());
    }

    private void runPrintWinningResult() {
        outputView.printWinningResultMessage();
        outputView.printLineSymbol();

        lottoService = new LottoService(userLotto.getUserNumbers(), lotto.getNumbers(), bonusLotto.getBonusNumber());
        lottoResults = lottoService.findWinningResult();

        for (Map.Entry<WinningResultConfig, Integer> lottoResult : lottoResults.entrySet()) {
            outputView.printWinningResult(lottoResult.getKey(),lottoResult.getValue());
        }
    }

    private void runPrintTotalRevenue() {

        List<Integer> rawRevenue = new ArrayList<>();

        for (Map.Entry<WinningResultConfig, Integer> entry : lottoResults.entrySet()) {
            rawRevenue.add(entry.getKey().getRevenueStatus(), entry.getValue());
        }

        outputView.printTotalRevenue(new Revenue(rawRevenue, amount.getAmount()).getRevenue());
    }
}
