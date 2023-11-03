package lotto.Controller;

import lotto.Model.UserLotto;
import lotto.View.PrintView;

public class MainController {
    InputController inputController;
    public MainController(){
        inputController = new InputController();
    }

    public void lottoStart(){
        int money = inputController.inputMoney();
        UserLotto lotto = inputController.inputNumbers();
        System.out.println(money);
        lotto.printNumbers();
    }


}
