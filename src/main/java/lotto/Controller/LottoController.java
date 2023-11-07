package lotto.Controller;

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
        Money money = startGame();
    }

    public Money startGame() {
        while (true) {
            try {
                return inputView.inputMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
