package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        User user = User.purchaseLottos(purchaseAmount);
        OutputView.printLottoNumbers(user.getNumberOfLottoTickets(), user.getAllLottoTicketsNumbers());
        Lotto winningLotto = createWinningLotto();
    }

    private PurchaseAmount readPurchaseAmount() {
        while (true) {
            try {
                PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.readPurchaseAmount());
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto createWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = InputView.readWinningNumbers();
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
