package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User {

    public int pay(String input) {
        int money;

        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }

        return money;
    }

    public List<Integer> inputWinningNumbers(String input) {
        String[] inputNumbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String inputNumber : inputNumbers) {
            winningNumbers.add(validateNumber(inputNumber));
        }

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요.");
        }

        if (new HashSet<>(winningNumbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력하세요.");
        }

        return winningNumbers;
    }

    public int inputBonusNumber(String input) {
        return validateNumber(input);
    }

    private Integer validateNumber(String inputNumber) {
        int number;

        try {
            number = Integer.parseInt(inputNumber);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }

        return number;
    }
}
