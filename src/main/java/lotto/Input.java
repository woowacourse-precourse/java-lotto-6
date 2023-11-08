package lotto;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static int getBonusNumber() {
        String input = Console.readLine();
        int bonusNumber = parseInt(input);

        if (isNotLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        return bonusNumber;
    }


    public static int getAmount() {
        String input = Console.readLine();
        int amount = parseInt(input);

        isValidLottoRange(!validAmount(amount));
        return amount;
    }

    public static List<Integer> getLottoNumbers() {
        String input = Console.readLine();

        isValidLottoRange(!isValidLottoFormat(input));

        String[] numbers = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();

        generateLottoNumbers(numbers, lottoNumbers);

        return lottoNumbers;
    }

    private static void generateLottoNumbers(String[] numbers, List<Integer> lottoNumbers) {
        for (int i = 0; i < numbers.length; i++) {
            int lottoNumber = parseInt(numbers[i]);
            lottoNumbers.add(lottoNumber);
        }

        for (int lottoNumber: lottoNumbers) {
            isValidLottoRange(isNotLottoNumber(lottoNumber));
        }
    }

    private static boolean isNotLottoNumber(int lottoNumber) {
        return lottoNumber < 1 || lottoNumber > 45;
    }

    private static void isValidLottoRange(boolean lottoNumber) {
        if (lottoNumber) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidLottoFormat(String input) {
        return input.matches("\\d{1,2}(,\\d{1,2}){5}$");
    }

    private static boolean validAmount(int amount) {
        return (amount % 1000) == 0;
    }
}
