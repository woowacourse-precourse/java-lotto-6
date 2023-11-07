package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.config.RankConfig;
import lotto.domain.Lotto;

public class OutputView {

    private static final String NUMBER_OF_LOTTO_TICKETS = "\n%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    private static final long PRIZE_ZERO = 0L;

    public static void printLottoTickets(List<Lotto> lottoNumbers){
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.toString());
        }
    }

    public static void printNumberOfLottoTickets(int count){
        System.out.println(String.format(NUMBER_OF_LOTTO_TICKETS, count));
    }

    public static void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

    public static void printLottoGameResult(HashMap<RankConfig, Integer> rankResult){
        System.out.println(WINNING_STATISTICS);
        RankConfig[] rankConfigs = RankConfig.values();

        for(RankConfig rank : rankConfigs){
            if(rank.getPrizeAmount() == PRIZE_ZERO) continue;
            System.out.println(rank.getPrizeDescription(rankResult.get(rank)));
        }
    }

    public static void printRateOfReturn(double rateOfReturn){
        System.out.println(String.format(TOTAL_RATE_OF_RETURN, rateOfReturn));
    }
}
