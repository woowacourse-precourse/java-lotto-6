package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Exception.LottoException;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.validation.InputValidator;
import lotto.validation.WinningNumberInputValidator;

public class WinningNumberInputController {

    InputValidator inputValidator = new InputValidator();
    WinningNumberInputValidator winningNumberInputValidator = new WinningNumberInputValidator();

    public Lotto inputWinningNumber() {
        String winningNumber = "";
        Lotto lotto;
        while (true) {
            winningNumber = Console.readLine();
            try {
                checkWinningNumber(winningNumber);
                lotto = splitWinningNumber(winningNumber);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
        return lotto;
    }

    public void checkWinningNumber(String winningNumber) throws IllegalArgumentException {
        if (!winningNumberInputValidator.isCommaFive(winningNumber)) {
            LottoException.notSixLottoNumber();
        }
    }

    public Lotto splitWinningNumber(String winningNumber) throws IllegalArgumentException {
        winningNumber = winningNumber.replace(" ", "");
        String[] number = winningNumber.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            if (!inputValidator.isNumber(number[i])) {
                LottoException.notNumber();
            }
            int oneNumber = Integer.parseInt(number[i]);
            numbers.add(oneNumber);
        }
        return checkWinningNumberLottoNumber(numbers);
    }

    public Lotto checkWinningNumberLottoNumber(List<Integer> numbers) throws IllegalArgumentException {
        for (int i = 0; i < numbers.size(); i++) {
            int oneNumber = numbers.get(i);
            if (!winningNumberInputValidator.isLottoNumber(oneNumber)) {
                LottoException.notLottoNumber();
            }
        }
        return new Lotto(numbers);
    }

    public int inputBonusNumber(Lotto winningLotto) {
        String bonusNumber = "";
        while (true) {
            try {
                bonusNumber = Console.readLine();
                checkBonusNumber(bonusNumber);
                checkBonusNumberDuplication(winningLotto, bonusNumber);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
        return Integer.parseInt(bonusNumber);
    }

    public void checkBonusNumber(String bonusNumber) throws IllegalArgumentException {
        if (!inputValidator.isNumber(bonusNumber)) {
            LottoException.notNumber();
        }
        checkBonusNumberRange(bonusNumber);
    }

    public void checkBonusNumberRange(String bonusNumber) throws IllegalArgumentException {
        int realBonusNumber = Integer.parseInt(bonusNumber);
        if (!winningNumberInputValidator.isLottoNumber(realBonusNumber)) {
            LottoException.notLottoNumber();
        }
    }

    public void checkBonusNumberDuplication(Lotto winningLotto, String bonusNumber) throws IllegalArgumentException {
        int realBonusNumber = Integer.parseInt(bonusNumber);
        WinningNumber winningNumber = new WinningNumber(winningLotto, realBonusNumber);
        if (!winningNumberInputValidator.isWinningLottoNotDuplication(winningNumber)) {
            LottoException.duplicationLottoNumber();
        }
    }
}
