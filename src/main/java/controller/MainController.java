package controller;

import static model.ProfitCalculator.calculateProfit;
import static model.ProfitCalculator.calculateRateOfProfit;
import static util.LottoGenerator.generateLotto;

import java.util.List;
import lotto.Lotto;
import model.MainModel;
import model.ProfitCalculator;
import util.LottoGenerator;
import view.Mainview;

public class MainController {
    private final static int STANDARD_MONEY = 1000;
    private Mainview view;
    private InputMan inputMan;

    private MainModel mainModel;
    private final static int EXCEPTION_NUMBER = -1;

    public void turnOn() {
        leadGame();
    }

    private int receiveValidMoney() {
        view.askForHowMany();
        int money = 0;
        while (true) {
            try {
                money = inputMan.receiveMoney();
                if (money == EXCEPTION_NUMBER) {
                    throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 하고 숫자만 입력해야 합니다.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }


    private Integer[] receiveValidNumbers() {
        view.requestNumbers();
        Integer[] userNumbers = null;

        while (true) {
            try {
                userNumbers = inputMan.receiveNumbers();
                if (userNumbers[0] == -1) {
                    throw new IllegalArgumentException("[ERROR] 제대로 된 숫자를 입력하세요.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userNumbers;
    }

    private Lotto makeUserLotto() {
        Integer[] userNumbers = receiveValidNumbers();
        Lotto userLotto = null;
        while (true) {
            try {
                userLotto = LottoGenerator.generateLotto(userNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                userNumbers = receiveValidNumbers();
            }
        }
        return userLotto;
    }

    private int receiveValidBonusNumber(Lotto userLotto)
    {
        view.requestBonusNumber();
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = inputMan.receiveBonusNumber(userLotto);
                if (bonusNumber == -1) {
                    throw new IllegalArgumentException("[ERROR]제대로 된 숫자를 입력하세요.");
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
