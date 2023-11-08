package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Exception.LottoException;
import lotto.domain.Lotto;
import lotto.validation.InputValidator;
import lotto.validation.WinningNumberInputValidator;

public class WinningNumberInputController {

    InputValidator inputValidator = new InputValidator();
    WinningNumberInputValidator winningNumberInputValidator = new WinningNumberInputValidator();
    LottoException lottoException = new LottoException();

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
            lottoException.notSixLottoNumber();
        }
    }

    public Lotto splitWinningNumber(String winningNumber) throws IllegalArgumentException {
        String[] number = winningNumber.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            int oneNumber = Integer.parseInt(number[i]);
            if (!winningNumberInputValidator.isLottoNumber(oneNumber)) {
                lottoException.notLottoNumber();
            }
            numbers.add(oneNumber);
        }
        return new Lotto(numbers);
    }

    public String inputBonusNumber() {
        return null;
    }
}
