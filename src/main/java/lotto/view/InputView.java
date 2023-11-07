package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NOT_NUMBER_MESSAGE = "숫자를 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String NUMBER_DELIMITER_MESSAGE = "번호는 쉼표(,)를 기준으로 구분됩니다.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static int getMoney() {
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
                String input = Console.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
            }
        }
    }

    public static List<Integer> getWinningNumber() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
                String input = Console.readLine();
                return convertStringToList(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NUMBER_DELIMITER_MESSAGE);
            }
        }
    }

    private static List<Integer> convertStringToList(String input) {
        String[] splitValues = input.split(",");
        return Arrays.stream(splitValues)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public static int getBonusNumber() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
                String input = Console.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
            }
        }
    }
}
