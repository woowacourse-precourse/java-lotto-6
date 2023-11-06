package lotto;

import java.util.List;

public class LottoGameController {

    private int purchaseAmount;
    private int purchaseCount;
    private String winningNumbers;
    private List<Integer> winningNumbersList;
    private int bonusNumber;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();

    public void playGame() {
        inputLottoPurchaseAmount();
        setLottoPurchaseCount();
        printPurchaseQuantity();
        generateLottoNumbers();
        printPurchasedLottoNumbers();
        setWinningNumbers();
        setWinningNumbersList();
        setBonusNumber();
        updateWinningCount();
    }

    void inputLottoPurchaseAmount() {
        purchaseAmount = Integer.parseInt(inputView.inputPurchaseAmount());
    }

    void setLottoPurchaseCount() {
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
    }

    public void setWinningNumbersList() {
        winningNumbersList = lottoGameService.convertWinningNumbersToCollection(winningNumbers);
    }

    public void setBonusNumber() {
        bonusNumber = Integer.parseInt(inputView.inputBonusNumber());
    }

    public void updateWinningCount() {
        for (List<Integer> purchasedLottoNumber : lottoGameService.getPurchasedLottoNumbers()) {
            lottoGameService.updateWinningCount(
                    lottoGameService.determineWinningRank(purchasedLottoNumber, winningNumbersList, bonusNumber)
            );
        }
    }
}
