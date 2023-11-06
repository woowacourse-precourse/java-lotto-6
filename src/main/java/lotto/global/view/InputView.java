package lotto.global.view;

import static lotto.domain.enums.ErrorMessage.NOT_NUMBER_INPUT_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String ENTER = System.lineSeparator();
    private static final String BUY_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = ENTER + "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = ENTER + "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_DELIMITER = ",";


    private InputView() {
    }

    private static int getInt() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    private static List<Integer> getNumbers() {
        try {
            String input = Console.readLine();
            return Arrays.stream(input.split(NUMBER_DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public static int getPurchaseMoney() {
        while (true) {
            System.out.println(BUY_LOTTO_MESSAGE);
            try {
                return getInt();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbersFromInput() {
        while (true) {
            System.out.println(WINNING_NUMBERS_MESSAGE);
            try {
                return getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber() {
        while (true) {
            System.out.println(BONUS_NUMBER_MESSAGE);
            try {
                return getInt();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
