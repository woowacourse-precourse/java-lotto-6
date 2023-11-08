package lotto;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static int getAmount() {
        String input = Console.readLine();
        int amount = parseInt(input);

        if (!validAmount(amount)) {
            throw new IllegalArgumentException();
        }
        return amount;
    }

    public static List<Integer> getLottoNumbers() {
        String input = Console.readLine();

        if (!isValidLottoFormat(input)) {
            throw new IllegalArgumentException();
        }

        String[] numbers = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int lottoNumber = parseInt(numbers[i]);
            lottoNumbers.add(lottoNumber);
        }

        for (int lottoNumber:lottoNumbers) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
        return lottoNumbers;
    }

    private static boolean isValidLottoFormat(String input) {
        return input.matches("\\d{1,2}(,\\d{1,2}){5}$");
    }

    private static boolean validAmount(int amount) {
        return (amount % 1000) == 0;
    }
}
