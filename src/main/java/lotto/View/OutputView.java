package lotto.View;

import lotto.domain.Lotto;
import lotto.domain.Ranks;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String BEFORE_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BEFORE_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String BEFORE_WINNING_COUNT = "\n당첨 통계 \n----";
    private static final String WINNING_COUNT_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String WINNING_COUNT_FORMAT_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    private static final String PROFIT_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";


    public void printGetMoney() {
        System.out.println(GET_MONEY_MESSAGE);
    }

    public void printTicketCount(int count) {
        System.out.println(count + TICKET_COUNT_MESSAGE);
    }

    public void printPurchasedLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printBeforeGetWinningNumber() {
        System.out.println(BEFORE_WINNING_NUMBER_MESSAGE);
    }

    public void printGetBonusNumber() {
        System.out.println(BEFORE_BONUS_NUMBER_MESSAGE);
    }


    public void printWinningCounts(List<Ranks> ranks) {
        System.out.println(BEFORE_WINNING_COUNT);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        for (int i = ranks.size() - 2; i >= 0; i--) {
            Ranks rank = ranks.get(i);
            String formattedPrize = decimalFormat.format(rank.getRankPrize());
            if(formattedPrize.equals("30,000,000")){
                printBonusWinningCounts(formattedPrize,rank);
                continue;
            }
            String winningCountMessage = String.format(WINNING_COUNT_FORMAT, rank.getMatchingNumbers(), formattedPrize, rank.getCount());
            System.out.println(winningCountMessage);
        }
    }
    public void printBonusWinningCounts(String formattedPrize, Ranks rank){
        String winningCountMessage = String.format(WINNING_COUNT_FORMAT_BONUS, rank.getMatchingNumbers(), formattedPrize, rank.getCount());
        System.out.println(winningCountMessage);
    }

    public void printprofitPercentage(float profitPercentage) {
        String formattedProfitMessage = String.format(PROFIT_MESSAGE_FORMAT, profitPercentage);
        System.out.println(formattedProfitMessage);
    }
}
