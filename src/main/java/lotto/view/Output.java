package lotto.view;

import lotto.domain.Ticket;

import java.util.List;

public class Output {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUYING_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE = "---";
    private static final String NEWLINE = "\n";
    private static final String RESULT_START_PREFIX = "[";
    private static final String RESULT_END_PREFIX = "]";
    private static final String DELIMITER = ",";

    private static Output output;

    public Output() {
    }

    public static Output getInstance() {
        if (output == null) {
            output = new Output();
        }
        return output;
    }

    public void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printBuyingMessage(int count) {
        System.out.println(String.format(BUYING_MESSAGE, count));
    }

    public void printLottoTickets(List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            System.out.println(TicketResult(ticket));
        }
    }

    public String TicketResult(Ticket ticket) {
        StringBuilder sb = new StringBuilder();
        sb.append(RESULT_START_PREFIX);
        for (int lottoNumber : ticket.getLotto()) {
            sb.append(lottoNumber).append(DELIMITER);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(RESULT_END_PREFIX);
        return sb.toString();
    }


    public void printWinningNumbersMessage() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE + NEWLINE + LINE);
        // 당첨 통계 결과 (나중에 구현)
        // 수익률 출력 (나중에 구현)
    }

}
