package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private User user;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public void start() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        user = User.purchaseLottos(purchaseAmount);
        OutputView.printLottoNumbers(user.getNumberOfLottoTickets(), user.getAllLottoTicketsNumbers());
        winningLotto = createWinningLotto();
        bonusNumber = readBonusNumber();
        user.compareLottos(winningLotto, bonusNumber);
        OutputView.printResult(user.getResult());
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

    private BonusNumber readBonusNumber() {
        while (true) {
            try {
                int bonusNumber = InputView.readBonusNumber();
                if (winningLotto.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호과 중복되지 않는 숫자를 입력해야 합니다.");
                }
                return new BonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
