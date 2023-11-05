package Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private  static final int MAX_LOTTO_NUMBER = 45;

    void validateWinningNumberLength(List<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    String deleteWhiteSpace(String winningNumber) {
        return winningNumber.replace("\\s", "");
    }

    String correctCommas(String winningNumber) {
        winningNumber = winningNumber.replaceAll("^,|,$", "");
        winningNumber = winningNumber.replaceAll(",+", ",");
        return winningNumber;
    }

    void validateWinningNumberNumeric(String winningNumber) {
        for (int winningNumberIndex  = 0; winningNumberIndex < winningNumber.length(); winningNumberIndex++) {
            if (!(Character.isDigit(winningNumber.charAt(winningNumberIndex)) || winningNumber.charAt(winningNumberIndex) == ',')) {
                throw new IllegalArgumentException();
            }
        }
    }
    void validateWinningNumberRange(List<Integer> winningNumber) {
        for (Integer lottoNumber : winningNumber) {
            if (MIN_LOTTO_NUMBER > lottoNumber || MAX_LOTTO_NUMBER < lottoNumber) {
                throw new IllegalArgumentException();
            }
        }
    }

    void validateWinningNumberDuplication(List<Integer> winningNumber) {
        Set<Integer> comparativeGroup = new HashSet<>(winningNumber);
        if (comparativeGroup.size() != winningNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    void validateBonusNumberDuplication(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
