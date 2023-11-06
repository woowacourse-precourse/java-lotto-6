package lotto.exception;

import java.util.ArrayList;
import java.util.List;
public class LottoNumberException {
    public static List<Integer> LottoNumberException(String input) {
        List<Integer> lotto_numbers = new ArrayList<>();
        String[] numberStrings = input.split(",");
        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString);
                lotto_numbers.add(number);
            } catch (NumberFormatException e) {}
        }
        return lotto_numbers;
    }
}

