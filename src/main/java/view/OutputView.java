package view;

import java.util.List;

import lotto.LottoMoney;

public class OutputView {
    private static final String LINEBREAK = "\n";
    private static final String LOTTO_TICKET_MESSAGE = "개를 구매했습니다.";
    private static final String LUCKEY_WINNING_STATSICS_MESSAGE = "당첨 통계";
    private static final String STICK = "-";
    private static final String[] REWARD = { " (5,000원) ", " (50,000원) ",
            " (1,500,000원) ", " (30,000,000원) ", " (2,000,000,000원) " };

    public void printLottoTicketMessage(LottoMoney lottoMoney) {
        System.out.println(LINEBREAK + lottoMoney.getLottoTicket() + LOTTO_TICKET_MESSAGE);
    }

    public void printLottoNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printLottoResultMessage() {
        System.out.println(LINEBREAK + LUCKEY_WINNING_STATSICS_MESSAGE + LINEBREAK + STICK.repeat(3));
    }

    public void printLottoResult(int winningNumber, int rewardIndex, String bonusMessage, int lottoWinnerCount) {
        System.out.println(winningNumber + "개 일치" + bonusMessage
                + REWARD[rewardIndex] + STICK + " " + lottoWinnerCount + "개");
    }

    public void printRevenuePercentage(double revenuePercentage) {
        System.out.println("총 수익률은 " + String.format("%.1f", revenuePercentage) + "%입니다.");
    }
}
