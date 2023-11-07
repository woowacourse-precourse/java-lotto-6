package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public static int purchaseAmount(String userInput) {
        try {
            int amount = Integer.parseInt(userInput);

            if (amount % 1000 != 0) {
                System.out.println("[ERROR] 1000원 단위로 입력 하세요.");
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력 하세요.");
            }
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력 하세요.");
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력 하세요.");
        }
    }

    public static int lotteryNumber(String numberString) {
        try {
            int number = Integer.parseInt(numberString);

            if (number < 0 || number > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력 하세요.");
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력 하세요.");
        }
    }

    public static void hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            if (numberSet.contains(number)) {
                System.out.println("[ERROR] 숫자를 중복 되지 않게 입력 하세요.");
                throw new IllegalArgumentException("[ERROR] 숫자를 중복 되지 않게 입력 하세요.");
            }
            numberSet.add(number);
        }
    }

    public static int bonusNumber(Lotto winningLottery, String userInput) {
        int bonusNumber = lotteryNumber(userInput);

        List<Integer> numbers = new ArrayList<>(winningLottery.getNumbers());
        numbers.add(bonusNumber);
        hasDuplicateNumbers(numbers);

        return bonusNumber;
    }
}
