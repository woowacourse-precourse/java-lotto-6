package lotto.view;

import static lotto.utils.calculator.Calculator.calculateLottoCount;
import static lotto.utils.calculator.Calculator.calculateWinningAmount;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoResults;
import lotto.domain.LottoResultsDTO;
import lotto.domain.LottosDTO;

public class OutputView {

    private static final String CURRENT_BOUGHT_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String TOTAL_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final String FIFTH_RANK_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH_RANK_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_RANK_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_RANK_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDE_LINE = "---";

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
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDE_LINE);
        printLottosStatistics(lottoResultsDTO.getResult());
    }

    public static void displayRateOfReturn(LottoResultsDTO lottoResultsDTO) {
        long buyLottoAmount = calculateLottoCount(lottoResultsDTO.getResult()) * 1000L;
        double rateOfReturn =
                (double) calculateWinningAmount(lottoResultsDTO.getResult()) / buyLottoAmount;
        System.out.printf(TOTAL_RATE_OF_RETURN_MESSAGE, rateOfReturn * 100);
    }

    private static void printLottosStatistics(Map<LottoResults, Integer> result) {
        System.out.printf(FIFTH_RANK_MESSAGE, result.getOrDefault(LottoResults.FIFTH, 0));
        System.out.printf(FOURTH_RANK_MESSAGE, result.getOrDefault(LottoResults.FOURTH, 0));
        System.out.printf(THIRD_RANK_MESSAGE, result.getOrDefault(LottoResults.THIRD, 0));
        System.out.printf(SECOND_RANK_MESSAGE, result.getOrDefault(LottoResults.SECOND, 0));
        System.out.printf(FIRST_RANK_MESSAGE, result.getOrDefault(LottoResults.FIRST, 0));
    }
}
