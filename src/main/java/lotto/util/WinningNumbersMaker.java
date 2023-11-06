package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class WinningNumbersMaker {
    private WinningNumbersMaker() {
    }

    public static Lotto makeWinningNumbers(String input) {
        List<Integer> separatedInput = separateNumbers(input);
        
    }

    public static List<Integer> separateNumbers(String input) {
        String[] separatedInput = input.split(",");
        List<Integer> separatedNumbers = new ArrayList<>();
        for (int i = 0; i < separatedInput.length; i++) {
            Integer number = Integer.parseInt(separatedInput[i]);
            separatedNumbers.add(number);
        }
        return separatedNumbers;
    }
}
