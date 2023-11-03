package lotto.Controller;

import lotto.Model.Lottos;
import lotto.Model.UserLotto;
import lotto.View.PrintView;

public class MainController {
    InputController inputController;
    LottoGeneratorController generatorController;

    public MainController(){
        inputController = new InputController();
        generatorController = new LottoGeneratorController();
    }

    public void lottoStart(){
        int money = inputController.inputMoney();
        Lottos lottos = generatorController.lottoGenerate(money);
        UserLotto lotto = inputController.inputNumbers();
        System.out.println(money);
        lotto.printNumbers();
    }


}
