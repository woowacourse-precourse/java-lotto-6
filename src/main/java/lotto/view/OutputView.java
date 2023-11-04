package lotto.view;

import java.util.List;

public class OutputView {
    private static final String ERROR_MESSAGE_TEXT = "[ERROR] %s\n";
    private static final String PURCHASE_PRICE_INPUT_TEXT = "구입금액을 입력해 주세요.\n";
    private static final String TICKET_NUMBER_TEXT = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBERS_TEXT = "[%s]\n";
    private static final String LOTTO_NUMBERS_INPUT_TEXT = "당첨 번호를 입력해 주세요.\n";
    private static final String BONUS_NUMBER_INPUT_TEXT = "보너스 번호를 입력해 주세요.\n";

    private OutputView() {
    }

    public static void printLottoNumbers(List<String> lottos) {
        lottos.forEach((lotto) -> System.out.printf(LOTTO_NUMBERS_TEXT, lotto));
        System.out.println();
    }
    public static void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_TEXT, errorMessage);
    }
    public static void printPurchasePriceInputText() {
        System.out.print(PURCHASE_PRICE_INPUT_TEXT);
    }

    public static void printTicketNumber (int ticketNumber) {
        System.out.printf(TICKET_NUMBER_TEXT, ticketNumber);
    }

    public static void printLottoNumbersInputText() {
        System.out.print(LOTTO_NUMBERS_INPUT_TEXT);
    }

    public static void printBonusNumberInputText () {
        System.out.print(BONUS_NUMBER_INPUT_TEXT);
    }
}
