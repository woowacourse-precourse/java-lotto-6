package lotto.view;

import java.util.List;

public class OutputView {

    private static final String INPUT_BUY_AMOUNT = "구매 금액을 입력하세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력하세요.";
    private static final String PURCHASED_TICKET_COUNT= "%d개를 구매했습니다.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printInputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT);
    }

    public static void printInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public static void printPurchaseTicketCount(int ticketCounts) {
        System.out.printf(PURCHASED_TICKET_COUNT, ticketCounts);
    }

    public static void printUserLottoNumbers(List<List<Integer>> userLottoNumbers) {
        for (List<Integer> userLotto : userLottoNumbers) {
            System.out.println(userLotto);
        }
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
