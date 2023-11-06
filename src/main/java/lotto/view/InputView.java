package lotto.view;

import static lotto.console.Console.println;
import static lotto.console.Console.readLine;

import java.util.List;
import lotto.parser.Parser;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_AMOUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static int readPurchaseAmountAndCount() {
        println(INPUT_PURCHASE_AMOUNT);
        int count = Parser.parseLottoCount(readLine());
        println("\n" + String.format(PURCHASE_AMOUNT_FORMAT, count));
        return count;
    }

    public static List<Integer> readPrizeNumber() {
        println("\n" + INPUT_PRIZE_NUMBER);
        return Parser.parseLotto(readLine());
    }

    public static int readBonusNumber() {
        println("\n" + INPUT_BONUS_NUMBER);
        return Parser.parseBonusNumber(readLine());
    }
}
