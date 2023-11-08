package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbersMaker {

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
