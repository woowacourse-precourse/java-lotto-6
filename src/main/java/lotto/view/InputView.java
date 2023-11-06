package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final String REQUEST_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.\n";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.\n";
    private static final String NUMBER_DELIMITER = ",";
    private static final int NUMBER_SPLIT_LIMIT = -1;

    public int readPurchaseAmount() {
        print(REQUEST_PURCHASE_AMOUNT_MESSAGE);
        return readInt();
    }

    public List<Integer> readWinningNumbers() {
        print(REQUEST_WINNING_NUMBER_MESSAGE);
        return readIntegerList();
    }

    public int readBonusNumber() {
        print(REQUEST_BONUS_NUMBER_MESSAGE);
        return readInt();
    }

    private List<Integer> readIntegerList() {
        return toIntegerList(read());
    }

    private List<Integer> toIntegerList(String string) {
        try {
            return tryToIntegerList(string);
        } catch (IllegalArgumentException exception) {
            String exceptionMessage = "각 숫자는 int 형식이고, 각 숫자는 \'%s\'로 구분해야 합니다".formatted(NUMBER_DELIMITER);
            throw new IllegalArgumentException(exceptionMessage, exception);
        }
    }

    private List<Integer> tryToIntegerList(String string) throws IllegalArgumentException {
        return Arrays.stream(string.split(NUMBER_DELIMITER, NUMBER_SPLIT_LIMIT))
                .map(this::tryToInteger)
                .toList();
    }

    private int readInt() {
        return toInteger(read());
    }

    private int toInteger(String string) {
        try {
            return tryToInteger(string);
        } catch (IllegalArgumentException exception) {
            String exceptionMessage = "int 형식의 숫자를 입력해야 합니다";
            throw new IllegalArgumentException(exceptionMessage, exception);
        }
    }

    private int tryToInteger(String string) throws IllegalArgumentException {
        return Integer.parseInt(string.trim());
    }

    private void print(String message) {
        System.out.print(message);
    }

    private String read() {
        return Console.readLine();
    }
}
