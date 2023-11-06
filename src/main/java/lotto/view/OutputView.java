package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.Result;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PLAYER_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_START_MESSAGE = "당첨 통계";
    private static final String RESULT_START_LINE = "---";
    private static final String RESULT_PROFIT_RATE_FIRST_MESSAGE = "총 수익률은 ";
    private static final String RESULT_PROFIT_RATE_LAST_MESSAGE = "%입니다.";
    private static final String RESULT_COUNT_FIRST_MESSAGE = " - ";
    private static final String RESULT_COUNT_LAST_MESSAGE = "개";

    public static void printPlayerLotto(List<Lotto> playerLotto){
        Integer playerLottoCount = playerLotto.size();
        System.out.println();
        System.out.println(playerLottoCount + PLAYER_LOTTO_COUNT_MESSAGE);
        for(Lotto lotto : playerLotto){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningResult(Result result){
        Map<LottoRanking, Integer> rankingCount = result.getRankingCount();
        String profitRate = String.format("%.1f",result.getProfitRate());
        System.out.println();
        System.out.println(RESULT_START_MESSAGE);
        System.out.println(RESULT_START_LINE);
        for(int i = LottoRanking.values().length - 2;i >= 0;i--){
            LottoRanking ranking = LottoRanking.values()[i];
            System.out.print(ranking.getWinningMessage() + RESULT_COUNT_FIRST_MESSAGE);
            System.out.println(rankingCount.get(ranking) + RESULT_COUNT_LAST_MESSAGE);
        }
        System.out.println(RESULT_PROFIT_RATE_FIRST_MESSAGE + profitRate + RESULT_PROFIT_RATE_LAST_MESSAGE);
    }
}
