package lotto.view;

import static lotto.utils.RepeatReader.read;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.IntegerConverter;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "%n당첨 번호를 입력해 주세요.%n";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "%n보너스 번호를 입력해 주세요.%n";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return IntegerConverter.convert(Console.readLine());
    }

    public static String inputWinningNumbers() {
        System.out.printf(INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.printf(INPUT_BONUS_NUMBER_MESSAGE);
        return read(() -> IntegerConverter.convert(Console.readLine()));
    }
}
