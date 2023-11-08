package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    private static final String LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void printLottoPurchaseMoneyMessage() {
        System.out.println(LOTTO_PURCHASE_MONEY_MESSAGE);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos()
            .forEach(l -> System.out.println(l.getLottoNumbers()));
        printEmptyLine();
    }

    public static void printLottoCountMessage(int lottoCount) {
        System.out.println(LOTTO_COUNT_MESSAGE.formatted(lottoCount));
    }

    public static void printWinningLottoMessage() {
        System.out.println(WINNING_LOTTO_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
