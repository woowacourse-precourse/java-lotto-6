package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;


public class LottoService {

    private List<Integer> winningNumbers;



    public int initMoneyToCount(String inputMoney) {
        int money = Validator.isNumber(inputMoney);
        return Validator.isDivide(money);
    }


    public List<Integer> initWinningNumbers(String inputWinningNumbers) {
        String[] inputNumbers = inputWinningNumbers.split(",");

        winningNumbers = new ArrayList<>();

        for (String inputNumber : inputNumbers) {
            int num = Validator.isNumber(inputNumber);
            Validator.isSmallAndBig(num);
            winningNumbers.add(num);
        }

        Validator.isSize(winningNumbers);
        Validator.isDuplicated(winningNumbers);
        return winningNumbers;
    }

    public int initBonusNumber(String inputBonusNumber) {
        int num = Validator.isNumber(inputBonusNumber);
        Validator.isSmallAndBig(num);
        Validator.isDuplicatedBonus(winningNumbers, num);

        return num;
    }


}
