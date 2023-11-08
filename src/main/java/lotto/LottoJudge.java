package lotto;

import lotto.Utils.Input;
import lotto.Utils.TypeChanger;
import lotto.Utils.ValidatorManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoJudge {
    private Input userInput = new Input();
    private TypeChanger changer = new TypeChanger();
    private ValidatorManager validatorManager = new ValidatorManager();


    public int userMoney() {
        String moneyInput;
        int money = 0;
        boolean validFlag = false;
        while (!validFlag) {
            moneyInput = userInput.purchaseAmount();
            try {
                money = validatorManager.validateAndParseMoneyManager(moneyInput);
                validFlag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
        return money;
    }


    public List<Integer> userLottoNumber() {
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

    public int userBonusNumber(List<Integer> lottoNumbers) {
        String bonusNumberInput;
        boolean validFlag = false;
        int bonusNumber = 0;

        do {
            bonusNumberInput = userInput.bonusNumber();
            try {
                validatorManager.validateBonusNumberManager(bonusNumberInput, lottoNumbers);
                bonusNumber = Integer.parseInt(bonusNumberInput.trim());
                validFlag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validFlag);

        return bonusNumber;
    }

}
