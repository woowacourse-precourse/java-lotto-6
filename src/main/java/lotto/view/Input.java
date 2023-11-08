package lotto.view;

import static lotto.error.ExceptionCode.INVALID_NUMBER_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.error.LottoException;

public class Input {

    public static final String BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static final String WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String NUMBER_DELIMITER = ",";

    public static long readBuyAmount() {
        System.out.println(BUY_AMOUNT_MESSAGE);
        return parseLong(Console.readLine());
    }

    public static List<Integer> readWinnerNumbers() {
        System.out.println(WINNER_NUMBER_MESSAGE);
        return Arrays.stream(Console.readLine().split(NUMBER_DELIMITER))
                .map(Input::parseInt).toList();
    }

    public static Integer readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return parseInt(Console.readLine());
    }

    private static long parseLong(final String input) {
        try {
            return Long.parseLong(input);
        } catch (final NumberFormatException e) {
            throw new LottoException(INVALID_NUMBER_FORMAT);
        }
    }

    private static Integer parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (final NumberFormatException e) {
            throw new LottoException(INVALID_NUMBER_FORMAT);
        }
    }
}
