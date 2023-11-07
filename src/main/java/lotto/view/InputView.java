package lotto.view;

import static lotto.common.exception.ExceptionMessages.INVALID_NUMBER_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.\n";
    public static final String INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.\n";
    public static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.\n";
    public static final String WINNING_NUMBER_SEPARATOR = ",";

    public long inputPurchaseAmount() {
        System.out.print(INPUT_PURCHASE_AMOUNT);
        String input = Console.readLine();
        return parseLong(input);
    }

    private long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.print(INPUT_WINNING_NUMBERS);
        String input = Console.readLine();

        return Arrays.stream(input.split(WINNING_NUMBER_SEPARATOR))
                .map(this::parseInt)
                .toList();
    }

    public int inputBonusNumber() {
        System.out.print(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        return parseInt(input);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
