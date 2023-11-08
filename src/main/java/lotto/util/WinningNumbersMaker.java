package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class WinningNumbersMaker {
    private WinningNumbersMaker() {
    }

    public static Lotto makeWinningNumbers(String input) {
        List<Integer> separatedNumbers = separateNumbers(input);
        return new Lotto(separatedNumbers);
    }

    public static List<Integer> separateNumbers(String input) {
        String[] separatedInput = input.split(",");
        List<Integer> separatedNumbers = new ArrayList<>();
        for (String inputNum : separatedInput) {
            Integer number = Integer.parseInt(inputNum);
            separatedNumbers.add(number);
        }
        return separatedNumbers;
    }
}
