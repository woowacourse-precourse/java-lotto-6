package lotto.controller;

import java.util.List;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private String purchaseAmount;
    private int purchaseCount;
    private String winningNumbers;
    private List<Integer> winningNumbersList;
    private String bonusNumber;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();

    public void playGame() {
        try {
            inputLottoPurchaseAmount();
            setLottoPurchaseCount();
            printPurchaseQuantity();
            generateLottoNumbers();
            printPurchasedLottoNumbers();
            setWinningNumbers();
            setBonusNumber();
            updateWinningCount();
            printWinningStatistics();
            printProfitRatio();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputLottoPurchaseAmount() {
        purchaseAmount = inputView.inputPurchaseAmount();
        lottoGameService.validatePurchaseAmount(purchaseAmount);
    }

    public void setLottoPurchaseCount() {
        purchaseCount = lottoGameService.getLottoTicketCount(purchaseAmount);
    }

    public void printPurchaseQuantity() {
        outputView.printPurchaseQuantity(purchaseCount);
    }

    public void generateLottoNumbers() {
        for (int i = 0; i < purchaseCount; i++) {
            lottoGameService.generateLottoNumbers();
        }
    }

    public void printPurchasedLottoNumbers() {
        outputView.printPurchasedLottoNumbers(lottoGameService.getPurchasedLottoNumbers());
    }

    public void setWinningNumbers() {
        winningNumbers = inputView.inputWinningNumbers();
        lottoGameService.validateWinningNumbers(winningNumbers);
        winningNumbersList = lottoGameService.convertWinningNumbersToCollection(winningNumbers);
        lottoGameService.validateWinningNumbersList(winningNumbersList);
    }

    public void setBonusNumber() {
        bonusNumber = inputView.inputBonusNumber();
        lottoGameService.validateBonusNumber(bonusNumber);
    }

    public void updateWinningCount() {
        for (List<Integer> purchasedLottoNumber : lottoGameService.getPurchasedLottoNumbers()) {
            lottoGameService.updateWinningCount(
                    lottoGameService.determineWinningRank(purchasedLottoNumber, winningNumbersList,
                            Integer.parseInt(bonusNumber))
            );
        }
    }

    public void printWinningStatistics() {
        outputView.printWinningStatistics(lottoGameService.getLottoRakingMap());
    }

    public void printProfitRatio() {
        outputView.printProfitRatio(lottoGameService.calculateProfitRate(
                purchaseAmount, lottoGameService.getLottoRakingMap()));
    }
}
