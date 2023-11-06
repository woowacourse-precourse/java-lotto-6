package lotto.view;

import lotto.model.UserMoney;

public class UserIoManager {
    private final InputView inputView;
    private final OutputView outputView;

    public UserIoManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public UserMoney readUserMoney() {
        outputView.printUserMoneyInputGuide();
        int userMoney = inputView.readUserMoney();
        return new UserMoney(userMoney);
    }
}
