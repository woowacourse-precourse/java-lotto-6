package lotto.controller;

import lotto.view.UserView;

public class LottoManager {
    private User user;
    private UserView userView;
    public LottoManager() {
        user = new User();
        userView = new UserView();
    }
    public void start() {
        userView.printBuyMessageBefore();
    }
}
