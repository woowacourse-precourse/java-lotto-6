package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.domain.Ranking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String LOTTO_BUY_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_STATIC_MESSAGE = "당첨 통계";
    private static final String LOTTO_RESULT_DIVIDE_MESSAGE = "---";
    private static final String LOTTO_RESULT_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private static final String LOTTO_RESULT_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String LOTTO_RESULT_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";


    public List<Lotto> printLottoNumber(int money) {
        int lottoCount = money / 1000;
        System.out.printf((LOTTO_BUY_MESSAGE) + "%n", lottoCount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public void printResult(Map<Ranking, Integer> result, int money) {
        System.out.println(LOTTO_STATIC_MESSAGE);
        System.out.println(LOTTO_RESULT_DIVIDE_MESSAGE);
        List<Ranking> rankings = new ArrayList<>(List.of(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH, Ranking.FIFTH));
        Collections.reverse(rankings);
        Long totalPrize = 0L;
        for (Ranking ranking : rankings) {
            if (ranking.equals(Ranking.SECOND)) {
                System.out.printf((LOTTO_RESULT_BONUS_MESSAGE) + "%n", ranking.getMatchCount(), ranking.getPrize(), result.getOrDefault(ranking, 0));
                totalPrize += (long) ranking.getPrize() * result.getOrDefault(ranking, 0);
                continue;
            }
            totalPrize += (long) ranking.getPrize() * result.getOrDefault(ranking, 0);
            System.out.printf((LOTTO_RESULT_MESSAGE) + "%n", ranking.getMatchCount(), ranking.getPrize(), result.getOrDefault(ranking, 0));
        }
        double profit = (double) totalPrize / (double) money * 100;
        printProfit(profit);
    }

    public void printProfit(double profit) {
        System.out.printf((LOTTO_RESULT_PROFIT_MESSAGE) + "%n", profit);
    }
}
