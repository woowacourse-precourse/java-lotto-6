package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public int readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        final String input = readLine();
        return parseInt(input);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        final String input = readLine();
        return Arrays.stream(input.split(DELIMITER))
                .map(this::parseInt)
                .toList();
    }

    public int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        final String input = readLine();
        return parseInt(input);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
        }
    }
}
