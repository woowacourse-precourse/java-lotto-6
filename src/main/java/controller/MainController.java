package controller;

import lotto.Lotto;
import model.LottoGenerator;
import model.MainModel;
import model.ProfitCalculator;
import validation.ValidationMan;
import view.Mainview;

public class MainController {
    private final static int STANDARD_MONEY = 1000;
    private Mainview mainview;
    private InputMan inputMan;
    private InputHelperController inputHelperController;
    private ResultHelperController resultHelperController;


    public MainController() {
        this.mainview = new Mainview();
        this.inputHelperController = new InputHelperController();
        this.inputMan = new InputMan(new ValidationMan());
        this.resultHelperController = new ResultHelperController(mainview);
    }

    public void turnOn() {
        leadGame();
    }

    private void leadGame() {
        int money = inputHelperController.checkAndRetryMoneyInput(inputMan::receiveMoney, mainview);
        MainModel mainModel = new MainModel(LottoGenerator.generateLotto(money / STANDARD_MONEY));
        Lotto userLotto = inputHelperController.proceedtoMakingLotto(inputMan::receiveNumbers,mainview);
        int bonusNumber = inputHelperController.checkAndRetryBonusNumberInput(inputMan, userLotto, mainview);
        resultHelperController.processLottoGame(new ProcessLottoGameParameters
                (new ProfitCalculator(), mainModel, userLotto, bonusNumber, money));
    }

}
