package lotto.exception;

import lotto.Constants;

import java.util.ArrayList;
import java.util.List;

public class Exception {
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

    public boolean checkAmount(int totalAmount, boolean correctAmount) {
        if (totalAmount % Constants.LOTTOPRICE != 0) {
            try {
                System.out.println("[ERROR] 금액은 1000 단위 숫자로 입력해주세요.");
                throw new IllegalArgumentException();
            } finally {
                return correctAmount;
            }
        }
        correctAmount = true;
        return correctAmount;
    }

    public List<Integer> checkNumbers(String lottoNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : lottoNumbers.split(",")) {
            int number = checkInt(str);
            if (number < 1 && number > 45 && numbers.contains(number)) {
                System.out.println("[ERROR] 1부터 45까지 중복되지 않은 6개의 숫자를 공백없이 쉼표로 구분하여 입력해주세요.");
                System.out.println("예시) 1,2,3,4,5,6");
                return numbers;
            }
            numbers.add(number);
        }
        if(numbers.size() != 6) {
            System.out.println("[ERROR] 1부터 45까지 중복되지 않은 6개의 숫자를 공백없이 쉼표로 구분하여 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public boolean checkBonus(String bonus) {
        return true;
    }
}
