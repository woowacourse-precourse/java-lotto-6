package lotto.cotroller;

import java.util.List;
import lotto.LottoService;
import lotto.domain.BonusNumber;
import lotto.LottoDTO;
import lotto.view.OutputView;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;

public class MainController {

    private final InputController inputController;
    private final OutputView outputView;
    private final LottoService service = new LottoService();
    private PurchaseAmount purchaseAmount;
    private WinningResult winningResult;

    public MainController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {
        purchaseLotto();
        getWinningResult();
        calculateTotalReturn();
    }

    private void purchaseLotto() {
        purchaseAmount = getPurchaseAmount();
        int amountOfPurchasedLotto = purchaseAmount.getAmountOfPurchasedLotto();

        service.createLottos(amountOfPurchasedLotto);
        printPurchasedLottoAmount(amountOfPurchasedLotto);
        printPurchasedLottos(service.getLottoDTOs());
    }

    private void getWinningResult() {
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);
        winningResult = service.getWinningResult(winningNumber, bonusNumber);
        outputView.printResult(winningResult.getResult());
    }

    private void calculateTotalReturn() {
        int totalPrize = winningResult.getTotalPrize();
        double totalReturn = purchaseAmount.getTotalReturn(totalPrize);
        outputView.printTotalReturn(totalReturn);
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            int purchaseAmount = inputController.getPurchaseAmount();
            return PurchaseAmount.from(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.getPurchaseAmount();
        }
    }

    private void printPurchasedLottos(List<LottoDTO> lottoDTOs) {
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