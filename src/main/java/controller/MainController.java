package controller;

import lotto.Lotto;
import model.LottoGenerator;
import model.MainModel;
import model.ProfitCalculator;
import validation.ValidationMan;
import view.Mainview;

public class MainController {
    private final static int STANDARD_MONEY = 1000;
    private InputMan inputMan;
    private InputHelperController inputHelperController;
    private ResultHelperController resultHelperController;
    private ProfitCalculator profitCalculator;
    private MainModel mainModel;

    public MainController(Mainview mainview, ValidationMan validationMan, ProfitCalculator profitCalculator) {
        this.inputHelperController = new InputHelperController(mainview);
        this.inputMan = new InputMan(validationMan);
        this.resultHelperController = new ResultHelperController(mainview);
        this.profitCalculator = profitCalculator;
    }

    public void turnOn() {
        leadGame();
    }

    private void leadGame() {
        int money = inputHelperController.checkAndRetryMoneyInput(inputMan::receiveMoney);
        mainModel = new MainModel(LottoGenerator.generateLotto(money / STANDARD_MONEY));
        Lotto userLotto = inputHelperController.proceedtoMakingLotto(inputMan::receiveNumbers);
        int bonusNumber = inputHelperController.checkAndRetryBonusNumberInput(inputMan, userLotto);
        resultHelperController.processLottoGame(new ProcessLottoGameParameters
                (new ProfitCalculator(), mainModel, userLotto, bonusNumber, money));
    }

}
