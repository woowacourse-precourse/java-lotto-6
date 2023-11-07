package lotto.Controller;

import lotto.Domain.Bonus;
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
