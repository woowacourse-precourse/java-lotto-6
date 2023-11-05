package lotto;

public class LottoGameController {

    private int purchaseAmount;
    private int purchaseCount;
    private String winningNumbers;
    private String bonusNumber;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();

    public void playGame() {
        inputLottoPurchaseAmount();
        setLottoPurchaseCount();
        printPurchaseQuantity();
        generateLottoNumbers();
        printPurchasedLottoNumbers();
    }

    void inputLottoPurchaseAmount() {
        this.purchaseAmount = Integer.parseInt(inputView.inputPurchaseAmount());
    }

    void setLottoPurchaseCount() {
        this.purchaseCount = lottoGameService.getLottoPurchaseCount(purchaseAmount);
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
        this.winningNumbers = inputView.inputWinningNumbers();
    }

    public void setBonusNumber() {
        this.bonusNumber = inputView.inputBonusNumber();
    }
}
