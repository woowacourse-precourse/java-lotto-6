package validation;

import camp.nextstep.edu.missionutils.Console;
import constant.Constants;
import java.awt.IllegalComponentStateException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExceptionHandler {

    public void validateIfOnlyNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new NumberFormatException();
            }
        }
    }

    public int validateBonusNumber(List<Integer> winningNumbers) {
        System.out.println(Constants.ENTER_BONUS_NUMBER_MESSAGE);
        String getBonusNumber = Console.readLine();
        int bonusNumber = Integer.parseInt(getBonusNumber);
        validateIfOnlyNumber(getBonusNumber);
        validateBonusNumberOneToFourtyFive(bonusNumber);
        validateExistInWinningNumbers(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    public void validateWinningNumberNumberOrComma(String getWinningNumbers) {
        for (int i = 0; i < getWinningNumbers.length(); i++) {
            if (!Character.isDigit(getWinningNumbers.charAt(i))
                    && getWinningNumbers.charAt(i) != ',') {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateMultipleOfThousand(int moneyToBuyLotto) {
        if (moneyToBuyLotto % 1000 != 0) {
            throw new IllegalStateException("[ERROR] 로또는 1000원 단위로 구매할 수 있습니다. 1000의 배수를 입력해주세요");
        }
    }

    public List<Integer> validateWinningNumber() {
        System.out.println(Constants.ENTER_WINNING_NUMBER_MESSAGE);
        String getWinningNumbers = Console.readLine();
        validateWinningNumberNumberOrComma(getWinningNumbers);
        List<Integer> winningNumbers = Arrays.stream(getWinningNumbers.split(",")).map(Integer::parseInt)
                .toList();
        validateOnlySixNumber(winningNumbers);
        validateWinningNumberOneToFourtyFive(winningNumbers);
        validateWinningNumberNoSameNumber(winningNumbers);
        return winningNumbers;
    }

    public void validateBonusNumberOneToFourtyFive(int bonusNumber) {
        if (bonusNumber < Constants.MIN_LOTTO_NUMBER || Constants.MAX_LOTTO_NUMBER < bonusNumber) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumberNoSameNumber(List<Integer> winningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>(winningNumbers);
        if (uniqueWinningNumbers.size() != winningNumbers.size()) {
            throw new IllegalComponentStateException();
        }
    }

    public void validateWinningNumberOneToFourtyFive(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (Constants.MIN_LOTTO_NUMBER > winningNumber || Constants.MAX_LOTTO_NUMBER < winningNumber) {
                throw new NumberFormatException();
            }
        }
    }

    public void validateOnlySixNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() > 6) {
            throw new IllegalStateException();
        }
    }

    public void validateExistInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalStateException();
        }
    }
}
