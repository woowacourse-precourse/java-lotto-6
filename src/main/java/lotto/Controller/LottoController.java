package lotto.Controller;

import lotto.Domain.Bonus;
import lotto.Domain.Lotto;
import lotto.Domain.Money;
import lotto.View.InputView;

public class LottoController {

    private static LottoController lottoController = new LottoController();
    private InputView inputView;

    private LottoController() {
        this.inputView = InputView.getInstance();
    }

    public static LottoController getInstance() {
        return lottoController;
    }

    public void run() {
        Money money = getMoney();
        Lotto lotto = getLotto();
        Bonus bonus = getBonus();
    }

    public Money getMoney() {
        while (true) {
            try {
                return inputView.inputMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto getLotto() {
        while (true) {
            try {
                return new Lotto(inputView.inputLotto());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Bonus getBonus() {
        while (true) {
            try {
                return inputView.inputBonus();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
