package lotto.view;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public void printLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + LOTTO_PURCHASE_MESSAGE);
    }

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void printWinningNumbersInputMessage() {
        System.out.println("\n" + WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println("\n" + BONUS_NUMBER_INPUT_MESSAGE);
    }
}
