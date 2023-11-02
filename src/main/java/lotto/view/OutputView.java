package lotto.view;

public class OutputView {
    private static final String PURCHASE_PRICE_INPUT_TEXT = "구입금액을 입력해 주세요.\n";
    private static final String TICKET_NUMBER_TEXT = "%d개를 구매했습니다.\n";

    private OutputView() {
    }

    public static void printPurchasePriceInputText() {
        System.out.println(PURCHASE_PRICE_INPUT_TEXT);
    }

    public static void printTicketNumber (int ticketNumber) {
        System.out.printf(TICKET_NUMBER_TEXT, ticketNumber);
    }

}
