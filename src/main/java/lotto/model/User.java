package lotto.model;

import lotto.controller.UserController;

public class User {

    private final UserController userController;
    private final UserWallet userWallet;

    User(){
        userController = new UserController();
        userWallet = new UserWallet();
    }

    public int useMoney(){
        return userWallet.buyLotto();
    }

}
