package lotto;

import lotto.Utils.Input;
import lotto.Utils.TypeChanger;
import lotto.Utils.Validator;

import java.util.List;


import static lotto.Utils.RandomNumber.generator;

public class LottoMachine {
    Input userInput = new Input();
    TypeChanger changer = new TypeChanger();
    Validator validator = new Validator();

    private int userMoney() {
        String moneyInput = userInput.purchaseAmount();
        int money = Integer.parseInt(moneyInput);
        try {
            validator.moneyValidator(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return money;
    }

    public int lottoAmount(int money) {
        return money / 1000;
    }

    private List<Integer> userLottoNumber() {
        String userNumberInput = userInput.enterNumbers();
        return changer.toIntegerList(userNumberInput);
    }


    private Lotto makeLotto() {
        Lotto lotto = new Lotto(userLottoNumber());
        return lotto;
    }

}
