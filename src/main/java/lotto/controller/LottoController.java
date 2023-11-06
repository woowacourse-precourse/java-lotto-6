package lotto.controller;

import java.util.List;
import lotto.model.PurchaseAmount;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private User user;

    public void startGame() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        user = User.purchaseLottos(purchaseAmount);
        OutputView.printLottoNumbers(user.getNumberOfLottoTickets(), user.getAllLottoTicketsNumbers());
        WinningLotto winningLotto = createWinningLotto();
        user.compareLottos(winningLotto);
        OutputView.printResult(user.getResult());
        OutputView.printProfitPercentage(user.calculateProfitPercentage(purchaseAmount));
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

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                return InputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = InputView.readBonusNumber();
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호과 중복되지 않는 숫자를 입력해야 합니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
