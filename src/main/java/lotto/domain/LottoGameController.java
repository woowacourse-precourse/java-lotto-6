package lotto.domain;

import lotto.global.view.InputView;

public class LottoGameController {

    public void run() {
        Money money = generateMoney();
        WinningLotto winningLotto = generateWinningLotto();
    }


    private Money generateMoney() {
        while (true) {
            try {
                int purchaseMoney = InputView.getPurchaseMoney();
                return new Money(purchaseMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto generateWinningLotto() {
        Lotto winningNumbers = generateLotto();
        while (true) {
            try {
                int bonusNumber = InputView.getBonusNumber();
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto generateLotto() {
        while (true) {
            try {
                return new Lotto(InputView.getWinningNumbersFromInput());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
