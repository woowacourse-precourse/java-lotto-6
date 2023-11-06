package lotto.controller;

import lotto.domain.User;
import lotto.io.InputStream;
import lotto.io.OutputStream;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final int ZERO = 0;
    private final InputView inputView;
    private final OutputView outputView;
    private final User user;

    public LottoController(InputStream inputStream, OutputStream outputStream) {
        this.inputView = new InputView(inputStream);
        this.outputView = new OutputView(outputStream);
        this.user = User.createByBudget(ZERO);
    }

    public void inputMoney() {
        while (true) {
            try {
                outputView.printMoneyInputMessage();
                int money = inputView.inputMoney();
                user.setBudget(money);
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }
}