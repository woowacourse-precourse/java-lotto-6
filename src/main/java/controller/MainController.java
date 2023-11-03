package controller;

import static model.ProfitCalculator.calculateRateOfProfit;

import java.util.concurrent.Callable;
import lotto.Lotto;
import model.LottoGenerator;
import model.MainModel;
import model.ProfitCalculator;
import view.Mainview;

public class MainController {
    private final static int STANDARD_MONEY = 1000;
    private Mainview view;
    private InputMan inputMan;

    private MainModel mainModel;
    private final static int EXCEPTION_NUMBER = -1;

    public MainController() {
        this.view = new Mainview();
        this.inputMan = new InputMan();
    }

    public void turnOn() {
        leadGame();
    }

    private int receiveValidMoney() {
        view.askForHowMany();
        return ExceptionProcessor.receiveAndExceptionForMoney(inputMan::receiveMoney);
    }


//    private Integer[] receiveValidNumbers() {
//        return ExceptionProcessor.receiveAndExceptionForNumbers(inputMan::receiveNumbers);
//    }

    private Lotto makeUserLotto() {
        view.requestNumbers();
        return ExceptionProcessor.proceedtoMakingLotto(inputMan::receiveNumbers);
    }

    private int receiveValidBonusNumber(Lotto userLotto)
    {
        view.requestBonusNumber();
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = inputMan.receiveBonusNumber(userLotto);
                if (bonusNumber == -1) {
                    throw new IllegalArgumentException("[ERROR] 제대로 된 숫자를 입력하세요.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private int[] proceedtoResult(Lotto userLotto, int bonusNumber)
    {
        int[] result = mainModel.judgeLotto(userLotto, bonusNumber);
        view.printHowManyAndLottos(mainModel.getComputerLottos());
        view.printresult(result);
        return result;
    }

    private void proceedToRateOfProfit(int money, int profit)
    {
        String rateOfProfit = calculateRateOfProfit(String.valueOf(money), profit);
        view.printRateOfProfit(rateOfProfit);
    }


    private void leadGame() {
        int money = receiveValidMoney();
        mainModel = new MainModel(LottoGenerator.generateLotto(money / STANDARD_MONEY));
        Lotto userLotto = makeUserLotto();
        int bonusNumber = receiveValidBonusNumber(userLotto);
        int profit = ProfitCalculator.calculateProfit(proceedtoResult(userLotto,bonusNumber));
        proceedToRateOfProfit(money,profit);
    }

}
