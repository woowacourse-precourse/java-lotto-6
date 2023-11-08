package lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.util.InputUtil;
import lotto.validator.WinningNumberValidator;

public class WinningNumber {
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;
    InputUtil inputUtil = new InputUtil();
    WinningNumberValidator validator = new WinningNumberValidator();

    public void setWinningNumbers() {
        inputWinningNumbers();
    }

    private void inputWinningNumbers() {
        String winningNumbersInput;
        while (true) {
            winningNumbersInput = inputUtil.inputWinningNumber();
            try {
                validator.checkLottoNumber(winningNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
            }
        }
        List<String> winningNumbersTemp = Arrays.asList(winningNumbersInput.split(","));
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(winningNumbersTemp.get(i)));
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
