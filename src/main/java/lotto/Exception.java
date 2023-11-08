package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    public static void printException(String message) {
        System.out.println("[ERROR] " + message);
        System.out.println();
    }

    public static void priceValidate(int price) {
        if(price == 0) {
            throw new IllegalArgumentException("로또를 최소 1장 구입하셔야 합니다.");
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("로또 1장의 가격은 1,000원입니다.");
        }
    }

    public static void numberTypeValidate(String input) {
        int number;
        try {
            if(input.contains(",")) {
                String[] numbers = input.split(",");
                for(String str : numbers) {
                    int strToNumber = Integer.parseInt(str);
                }
            } else {
                number = Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하셔야 합니다.");
        }
    }

    public static void lottoNumberValidate(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력하셔야 합니다.");
        }

        Set<Integer> checkDuplication = new HashSet<>();
        for(int number : winningNumbers) {
            checkDuplication.add(number);
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        if(winningNumbers.size() != checkDuplication.size()) {
            throw new IllegalArgumentException("중복된 번호를 입력하셨습니다.");
        }
    }

    public static void bonusNumberValidate(int bonusNumber, List<Integer> winningNumbers) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        for(int number : winningNumbers) {
            if(number == bonusNumber) {
                throw new IllegalArgumentException("당첨번호에 중복된 번호가 존재합니다.");
            }
        }
    }
}
