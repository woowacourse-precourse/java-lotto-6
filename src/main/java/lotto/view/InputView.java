package lotto.view;

import static lotto.constant.ErrorMessage.NOT_NUMBER;
import static lotto.constant.InputMessage.BONUS_NUMBER;
import static lotto.constant.InputMessage.LOTTO_PURCHASE_MONEY;
import static lotto.constant.InputMessage.LOTTO_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String WINNING_NUMBERS_SEPARATOR = ",";

    public static int readLottoPurchaseMoney() {
        System.out.println(LOTTO_PURCHASE_MONEY);
        return stringToInt(Console.readLine());
    }

    public static List<Integer> readLottoWinningNumbers() {
        System.out.println(LOTTO_WINNING_NUMBERS);
        return convertWinningNumbers(Console.readLine());
    }

    private static List<Integer> convertWinningNumbers(String inputNumbers) {
        String[] numbers = inputNumbers.split(WINNING_NUMBERS_SEPARATOR);
        return Arrays.stream(numbers).map(number -> stringToInt(number)).toList();
    }

    public static int readBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return stringToInt(Console.readLine());
    }

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }


}
