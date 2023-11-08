package lotto.controller;

import java.util.List;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();
    private String purchaseAmount;
    private int purchaseCount;
    private List<Integer> winningNumbers;
    private String bonusNumber;

    public void playGame() {
        try {
            inputLottoPurchaseAmount();
            setLottoPurchaseCount();
            printPurchaseQuantity();
            generateLottoTicket();
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

    public void generateLottoTicket() {
        for (int generateIndex = 0; generateIndex < purchaseCount; generateIndex++) {
            lottoGameService.generateLottoNumbers();
        }
    }

    public void printPurchasedLottoNumbers() {
        outputView.printPurchasedLottoNumbers(lottoGameService.getPurchasedLottoNumbers());
    }

    public void setWinningNumbers() {
        String inputNumbers = inputView.inputWinningNumbers();
        lottoGameService.validateInputNumbers(inputNumbers);
        winningNumbers = lottoGameService.convertStringToCollection(inputNumbers);
        lottoGameService.validateWinningNumbers(winningNumbers);
    }

    public void setBonusNumber() {
        bonusNumber = inputView.inputBonusNumber();
        lottoGameService.validateBonusNumber(bonusNumber, winningNumbers);
    }

    public void updateWinningCount() {
        for (List<Integer> purchasedLottoNumber : lottoGameService.getPurchasedLottoNumbers()) {
            lottoGameService.updateWinningCount(
                    lottoGameService.determineWinningRank(
                            purchasedLottoNumber,
                            winningNumbers,
                            Integer.parseInt(bonusNumber)));
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
