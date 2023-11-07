package lotto.validation;

import java.util.*;

public class InputValidator {
    private static final int LOTTO_UNIT_AMOUNT = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static void validInputMoney(String lottoMoney) {
        if (isDigit(lottoMoney)) {
            throw new IllegalArgumentException("구입 금액은 숫자만 입력할 수 있습니다.");
        }
        if (isDivisible(lottoMoney) || isMoneyRange(lottoMoney)) {
            throw new IllegalArgumentException("최소 금액은 1000원으로, 1000원 단위의 금액이어야 합니다.");
        }
    }

    public static void validWinningNumber(List<Integer> numbers) {
        if (isNumberRange(numbers)) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (isNumberSize(numbers)) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }
        if (isUnique(numbers)) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 숫자여야 합니다.");
        }
    }

    public static void validBonusNumber(String bonusNumber, List<Integer> winningNumber) {
        if (isBonusNumberRange(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (isInWinningNumber(Integer.parseInt(bonusNumber), winningNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않은 숫자여야 합니다.");
        }
    }


    private static boolean isDigit(String lottoMoney) {
        String pattern = "^[0-9]*$";
        return !lottoMoney.matches(pattern);
    }

    private static boolean isDivisible(String lottoMoney) {
        return (Integer.parseInt(lottoMoney) % LOTTO_UNIT_AMOUNT) > 0;
    }

    private static boolean isMoneyRange(String lottoMoney) {
        return Integer.parseInt(lottoMoney) < LOTTO_UNIT_AMOUNT;
    }

    private static boolean isNumberRange(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBonusNumberRange(int bonusNumber) {
        return (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER);
    }

    private static boolean isNumberSize(List<Integer> winningNumber) {
        return winningNumber.size() != LOTTO_SIZE;
    }

    private static boolean isUnique(List<Integer> winningNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumber);
        return uniqueNumbers.size() != LOTTO_SIZE;
    }

    private static boolean isInWinningNumber(int bonusNumber, List<Integer> winningNumber) {
        return winningNumber.contains(bonusNumber);
    }
}