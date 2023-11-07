package lotto;

import java.util.List;

public class MainController {

    private final InputController inputController = new InputController(new InputView());
    private final OutputView outputView = new OutputView();

    public MainController() {
    }

    public void run() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        int amountOfPurchasedLotto = purchaseAmount.getAmountOfPurchasedLotto();

        Lottos lottos = createLottos(amountOfPurchasedLotto);
        printPurchasedLottoAmount(amountOfPurchasedLotto);
        printPurchasedLottos(lottos);

        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);
        WinningResult winningResult = lottos.getWinningResult(winningNumber, bonusNumber);

        Map<Rank, Integer> result = winningResult.getResult();
        outputView.printResult(result);
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            return inputController.getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.getPurchaseAmount();
        }
    }

    private Lottos createLottos(int amountOfPurchasedLotto) {
        List<Lotto> lottoList = LottoMaker.makeLotto(amountOfPurchasedLotto);
        return new Lottos(lottoList);
    }

    private void printPurchasedLottos(Lottos lottos) {
        List<LottoDTO> lottoDTOs = lottos.getLottoDTOs();
        outputView.printPurchasedLottos(lottoDTOs);
    }

    private void printPurchasedLottoAmount(int amountOfPurchasedLotto) {
        outputView.printPurchasedLottoAmount(amountOfPurchasedLotto);
    }

    private WinningNumber getWinningNumber() {
        try {
            List<Integer> numbers = inputController.getWinningNumber();
            return WinningNumber.from(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.getWinningNumber();
        }
    }

    private BonusNumber getBonusNumber(WinningNumber winningNumber) {
        try {
            int bonusNumber = inputController.getBonusNumber();
            return new BonusNumber(bonusNumber, winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.getBonusNumber(winningNumber);
        }
    }
}