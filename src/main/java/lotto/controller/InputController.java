package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.Money;
import lotto.view.OutputView;

public class InputController {
    public Integer getMoney() {
        String given = Console.readLine();
        try {
            int givenMoney = checkNumber(given);
            Money.checkMoney(givenMoney);
            return givenMoney;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return getMoney();
        }
    }

    public List<Integer> getLottoNumber() {
        String given = Console.readLine();
        try {
            List<Integer> arr = Arrays.stream(given.split(",")).map(this::checkNumber).toList();
            lottoNumberRangeCheck(arr);
            return arr;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return getLottoNumber();
        }
    }

    public Integer getBonusNumber() {
        String given = Console.readLine();
        try {
            Integer bonusNumber = checkNumber(given);
            lottoNumberRangeCheck(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return getBonusNumber();
        }
    }

    public Integer checkNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void lottoNumberRangeCheck(List<Integer> arr) {
        for (Integer item : arr) {
            lottoNumberRangeCheck(item);
        }
    }

    public void lottoNumberRangeCheck(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}
