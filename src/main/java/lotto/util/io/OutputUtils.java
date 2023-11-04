package lotto.util.io;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputUtils {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String RESULTS_ANNOUNCEMENT_MESSAGE = "당첨 통계";
    private static final String SEPARATING_LINE = "---";
    private static final String WINNING_DETAIL = "%s (%s원) - %d개";

    public static void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public static void printNumberOfPurchaseMessage(int number) {
        System.out.println(String.format(NUMBER_OF_PURCHASE_MESSAGE, number));
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printResultAnnouncementMessage() {
        System.out.println(RESULTS_ANNOUNCEMENT_MESSAGE);
        System.out.println(SEPARATING_LINE);
    }

    public static void printWinningDetail(String description, String prize, int number) {
        System.out.println(String.format(WINNING_DETAIL, description, prize, number));
    }
}
