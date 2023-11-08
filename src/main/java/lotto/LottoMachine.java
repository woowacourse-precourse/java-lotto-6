package lotto;

import lotto.Utils.Input;
import lotto.Utils.TypeChanger;
import lotto.Utils.ValidatorManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    Input userInput = new Input();
    TypeChanger changer = new TypeChanger();
    ValidatorManager validatorManager = new ValidatorManager();


    private int userMoney() {
        String moneyInput;
        boolean validFlag = false;
        do {
            moneyInput = userInput.purchaseAmount();
            try {
                validatorManager.validateAndParseMoneyManager(moneyInput);
                validFlag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        } while (!validFlag);
        return Integer.parseInt(moneyInput);
    }

    public int lottoAmount() {
        return userMoney() / 1000;
    }

    private List<Integer> userLottoNumber() {
        String userNumberInput;
        Set<Integer> lottoNumbersSet = new HashSet<>();
        List<Integer> lottoNumbersList;
        boolean validFlag = false;

        do {
            userNumberInput = userInput.enterLottoNumbers();
            try {
                validatorManager.validateLottoNumbersManager(userNumberInput, lottoNumbersSet);
                validFlag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        } while (!validFlag);

        lottoNumbersList = changer.toIntegerList(userNumberInput);
        return lottoNumbersList;
    }

    public Lotto makeLotto() {
        Lotto lotto = new Lotto(userLottoNumber());
        return lotto;
    }

    private ComputerLotto makecomputerLottos() {
        int makeAmount = lottoAmount();
        ComputerLotto computerLottos = new ComputerLotto(makeAmount);
        return computerLottos;
    }
}
