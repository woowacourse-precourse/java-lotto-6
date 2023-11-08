package lotto;

import java.sql.Array;
import java.util.*;

public class LottoNumbersMaker {
    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    public static Lotto generateWinningNumbers(String input) {
        String[] winningNumbersInput = input.split(",");
        Set<Integer> winningNumbers = new HashSet<>();
        for (String winningNumber : winningNumbersInput) {
            try {
                int number = Integer.parseInt(winningNumber);
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
            }
        }
        return new Lotto(new ArrayList<>(winningNumbers));
    }
}
