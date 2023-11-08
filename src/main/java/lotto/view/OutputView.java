package lotto.view;

import java.util.StringJoiner;
import lotto.domain.lotto.Lotto;
import lotto.dto.LottosResponse;

public class OutputView {

    private static final String LOTTO_PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.\n";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBERS_PROMPT = "\n당첨 번호를 입력해 주세요.\n";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.\n";

    public static void printLottoPurchaseAmountPrompt() {
        System.out.print(LOTTO_PURCHASE_AMOUNT_PROMPT);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public static void printWinningNumbersPrompt() {
        System.out.print(WINNING_NUMBERS_PROMPT);
    }

    public static void printBonusNumberPrompt() {
        System.out.print(BONUS_NUMBER_PROMPT);
    }

    public static void printLottos(LottosResponse lottosResponse) {
        for (Lotto lotto : lottosResponse.getLottos().asList()) {
            StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
            lotto.getNumbers().forEach(
                number -> stringJoiner.add(String.valueOf(number))
            );
            printLotto(stringJoiner.toString());
        }
    }

    public static void printLotto(String lotto) {
        System.out.print(lotto + "\n");
    }

    public static void printError(String errorMessage) {
        System.out.print(errorMessage + "\n");
    }
}
