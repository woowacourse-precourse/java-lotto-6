package lotto.exception;

import lotto.domain.Constants;

import java.util.ArrayList;
import java.util.List;

public class Exception {
    List<Integer> numbers = null;

    public Exception() {
        numbers = new ArrayList<>();
    }

    public int checkInt(String totalAmount) {
        int amount = 0;
        try {
            amount = Integer.parseInt(totalAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        } finally {
            return amount;
        }
    }

    public boolean checkAmount(int totalAmount, boolean correctAmount, String message) {
        if (totalAmount % Constants.LOTTOPRICE != 0) {
            System.out.println(message);
            try {
                throw new IllegalArgumentException();
            } finally {
                return correctAmount;
            }
        }
        System.out.println();
        return !correctAmount;
    }

    public List<Integer> checkNumbers(String lottoNumbers) {
        String message = "[ERROR] 1부터 45까지 중복되지 않은 6개의 숫자를 공백없이 쉼표로 구분하여 입력해주세요.";
        for (String str : lottoNumbers.split(",")) {
            int number = checkInt(str);
            if (number < 1 || number > 45 || numbers.contains(number)) {
                System.out.println(message);
                try {
                    throw new IllegalArgumentException();
                } finally {
                    return checkLength(numbers);
                }
            }
            numbers.add(number);
        }
        return checkLength(numbers);
    }

    public List<Integer> checkLength(List<Integer> numbers) {
        String message = "[ERROR] 1부터 45까지 중복되지 않은 6개의 숫자를 공백없이 쉼표로 구분하여 입력해주세요.";
        if (numbers.size() != 6) {
            System.out.println(message);
            try {
                throw new IllegalArgumentException();
            } finally {
                return numbers;
            }
        }
        return numbers;
    }

    public int checkBonus(List<Integer> winningNumber, String bonus) {
        String message = "[ERROR] 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자 1개를 입력해주세요.";
        int bonusNumber = checkInt(bonus);
        if (winningNumber.contains(bonusNumber) || bonusNumber < 1 || bonusNumber > 45) {
            System.out.println(message);
            try {
                throw new IllegalArgumentException();
            } finally {
                return bonusNumber;
            }
        }
        return bonusNumber;
    }
}
