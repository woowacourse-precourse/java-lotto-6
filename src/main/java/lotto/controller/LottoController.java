package lotto.controller;

import lotto.enums.LottoNumber;
import lotto.model.Statistics;
import lotto.service.LottoService;
import lotto.util.Verifier;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private static final String LOTTO_NUMBER_SPLIT = ",";
    LottoService lottoService;
    OutputView outputView;
    InputView inputView;
    List<Integer> winningNumbers;
    Integer bonusNumber;
    Statistics statistics;

    public LottoController() {
        this.lottoService = new LottoService();
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        lottoService.createLottos(getLottoCount());

        outputView.printPurchaseQuantity(lottoService.getLottoCount());
        outputView.printLottos(lottoService.getLottos());

        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();
        statistics = createStatistics();

        outputView.winningStatistics(statistics);
    }

    private Integer getLottoCount() {
        return getPurchaseAmount() / LottoNumber.PRICE.getNumber();
    }

    private Integer getPurchaseAmount() {
        try {
            return inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getPurchaseAmount();
    }

    private Integer inputPurchaseAmount() {
        String purchaseAmountInput;
        Integer purchaseAmount;

        purchaseAmountInput = inputView.purchaseAmount();
        Verifier.validateOnlyNumber(purchaseAmountInput);

        purchaseAmount = Integer.parseInt(purchaseAmountInput);
        Verifier.validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    private List<Integer> getWinningNumbers() {
        try {
            return inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getWinningNumbers();
    }

    private List<Integer> inputWinningNumbers() {
        String winningNumberInput;
        List<Integer> winningNumbers;

        winningNumberInput = inputView.winningNumbers();
        Verifier.validateWinningNumberInput(winningNumberInput);

        winningNumbers = Arrays.stream(winningNumberInput.split(LOTTO_NUMBER_SPLIT))
                .map(Integer::parseInt)
                .toList();
        Verifier.validateWinningNumber(winningNumbers);

        return winningNumbers;
    }

    private Integer getBonusNumber() {
        try {
            return inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getBonusNumber();
    }

    private Integer inputBonusNumber() {
        String bonusNumberInput;
        Integer bonusNumber;

        bonusNumberInput = inputView.bonusNumber();
        Verifier.validateOnlyNumber(bonusNumberInput);

        bonusNumber = Integer.parseInt(bonusNumberInput);
        Verifier.validateBonusNumber(bonusNumber, winningNumbers);

        return bonusNumber;
    }


    public Statistics createStatistics() {
        ArrayList<Integer> rankCount = lottoService.getRankCount(winningNumbers, bonusNumber);
        return new Statistics(rankCount, lottoService.getPurchaseAmount());
    }
}
