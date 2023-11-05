package lotto.service;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import lotto.domain.User;
import lotto.util.Sort;
import lotto.validator.NumberValidator;
import lotto.domain.Admin;

public class AdminLottoService {
    Set<Integer> winningNumber = new HashSet<Integer>();

    public ArrayList<Integer> initWinningNumber(String[] winningNumbers) {
        NumberValidator.validateInputWinningNumber(winningNumbers);
        for (int i = 0; i < winningNumbers.length; i++) {
            int parseWinningNumber = Integer.parseInt(winningNumbers[i]);
            winningNumber.add(parseWinningNumber);
        }
        NumberValidator.validateWinnerNumberSize(winningNumber);
        return Sort.sortWinningNumber(winningNumber);
    }

    public String[] splitWinningNumbers(String winningNumberStr) {
        String winningNumbers = winningNumberStr.replaceAll(" ", "");
        String[] splitCarNameList = winningNumbers.split(",", -1);
        return splitCarNameList;
    }

    public int parseIntBonusNumber(String bonusNumberStr) {
        int bonusNumber = Integer.parseInt(bonusNumberStr);
        NumberValidator.validateNumberRange(bonusNumber);
        winningNumber.add(bonusNumber);
        NumberValidator.validateWinnerNumberSize(winningNumber);
        return bonusNumber;
    }

    public Admin setAdmin(ArrayList<Integer> winningNumbers, int bonusNumber) {
        return new Admin(winningNumbers, bonusNumber);
    }

    public void compareCorrectLottoNumbers() {

    }
}
