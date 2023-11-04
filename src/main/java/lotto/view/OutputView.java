package lotto.view;

import lotto.model.LottoTicket;

public final class OutputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";

    private OutputView() {
    }

    public static void printPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printNumberOfLotto(int NumberOfLotto) {
        printEmptyLine();
        System.out.printf(PURCHASE_MESSAGE, NumberOfLotto);
    }

    public static void printLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.getLottos()
                .forEach(System.out::println);
    }

    public static void printWinningNumbersMessage() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
