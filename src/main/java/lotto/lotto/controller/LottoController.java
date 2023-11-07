package lotto.lotto.controller;

import java.util.List;

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
        List<Integer> numbers = userController.lottoNumberInput();
        userController.lottoBonusNumberInput(numbers);
    }
}
