package lotto.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoResults;
import lotto.domain.LottoResultsDTO;
import lotto.domain.LottosDTO;

public class OutputView {

    private static final String CURRENT_BOUGHT_LOTTO_MESSAGE = "개를 구매했습니다.";

    private OutputView() {
    }

    public static void displayAllLottos(LottosDTO lottosDTO) {
        List<List<Integer>> lottos = lottosDTO.getLottos();
        System.out.println(lottos.size() + CURRENT_BOUGHT_LOTTO_MESSAGE);
        for (List<Integer> lotto : lottos) {
            ArrayList<Integer> copyLotto = new ArrayList<>(lotto);
            copyLotto.sort(Comparator.naturalOrder());
            System.out.println(copyLotto);
        }
    }

    public static void displayAllLottosStatistics(LottoResultsDTO lottoResultsDTO) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printLottosStatistics(lottoResultsDTO.getResult());
    }

    public static void displayRateOfReturn(LottoResultsDTO lottoResultsDTO) {
        Map<LottoResults, Integer> result = lottoResultsDTO.getResult();
        int lottoCount = result.values().stream()
                .reduce(0, Integer::sum);
        double rateOfReturn = (double) calculateWinningAmount(result) / (lottoCount * 1000L);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn * 100);
    }

    private static void printLottosStatistics(Map<LottoResults, Integer> result) {
        System.out.printf("3개 일치 (5,000원) - %d개\n", result.getOrDefault(LottoResults.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", result.getOrDefault(LottoResults.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result.getOrDefault(LottoResults.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
                result.getOrDefault(LottoResults.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",
                result.getOrDefault(LottoResults.FIRST, 0));
    }

    private static long calculateWinningAmount(Map<LottoResults, Integer> result) {
        long totalAmount = 0;
        for (LottoResults lottoResults : LottoResults.values()) {
            long winningAmount = lottoResults.getWinningAmount();
            int rankCount = result.getOrDefault(lottoResults, 0);
            totalAmount += winningAmount * rankCount;
        }
        return totalAmount;
    }
}
