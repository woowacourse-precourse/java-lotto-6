package lotto.lotto.controller;

import lotto.user.controller.UserController;

public class LottoController {
    private LottoController(){ }
    private static final LottoController instance = new LottoController();

    public static LottoController getInstance(){
        return instance;
    }

    public void start(){
        UserController userController = UserController.getInstance();
        userController.purchaseInput();
        userController.lottoNumberInput();
        userController.lottoBonusNumberInput();
    }
}
