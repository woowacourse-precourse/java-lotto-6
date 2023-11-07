package lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;
import lotto.util.InputUtil;
import lotto.validator.WinningNumberValidator;


public class WinningNumber {
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;
    Constants constants = new Constants();
    InputUtil inputUtil = new InputUtil();
    WinningNumberValidator validator = new WinningNumberValidator();


    public void setWinningNumbers() {
        inputWinningNumbers();
    }

    private void inputWinningNumbers() {
        List<String> winningNumbersInput;
        while (true) {
            winningNumbersInput = Arrays.asList(inputUtil.inputWinningNumber().split(","));
            try {
                validator.checkLottoNumber(winningNumbersInput);
                break;
            } catch (IllegalArgumentException e) {

            }
        }

        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(winningNumbersInput.get(i)));
        }
    }

    public void setBonusNumber() {
        inputBonusNumber();
    }

    private void inputBonusNumber() {
        String bonusNumberInput;
        while (true) {
            bonusNumberInput = inputUtil.inputBonusNumber();
            try {
                validator.checkBonusNumber(winningNumbers, bonusNumberInput);
                break;
            } catch (IllegalArgumentException e) {

            }
        }
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

}
