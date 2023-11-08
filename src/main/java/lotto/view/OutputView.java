package lotto.view;

import static lotto.constant.OutputViewMessage.CURRENT_BOUGHT_LOTTO_MESSAGE;
import static lotto.constant.OutputViewMessage.DIVIDE_LINE;
import static lotto.constant.OutputViewMessage.FIFTH_RANK_MESSAGE;
import static lotto.constant.OutputViewMessage.FIRST_RANK_MESSAGE;
import static lotto.constant.OutputViewMessage.FOURTH_RANK_MESSAGE;
import static lotto.constant.OutputViewMessage.SECOND_RANK_MESSAGE;
import static lotto.constant.OutputViewMessage.THIRD_RANK_MESSAGE;
import static lotto.constant.OutputViewMessage.TOTAL_RATE_OF_RETURN_MESSAGE;
import static lotto.constant.OutputViewMessage.WINNING_STATISTICS_MESSAGE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoResults;
import lotto.domain.LottoResultsDTO;
import lotto.domain.LottosDTO;

public class OutputView {

    private OutputView() {
    }

    public static void displayAllLottos(LottosDTO lottosDTO) {
        List<List<Integer>> lottos = lottosDTO.lottos();
        String formattedLottoOutput = String.format(CURRENT_BOUGHT_LOTTO_MESSAGE, lottos.size())
                + createFormattedLottosOutput(lottos);
        System.out.println(formattedLottoOutput);
    }

    public static void displayAllLottosStatistics(LottoResultsDTO lottoResultsDTO) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDE_LINE);
        printLottosStatistics(lottoResultsDTO.result());
    }

    public static void displayRateOfReturn(LottoResultsDTO lottoResultsDTO) {
        long buyLottoAmount = lottoResultsDTO.buyAmount();
        double rateOfReturn = (double) lottoResultsDTO.winningAmount() / buyLottoAmount;
        System.out.printf(TOTAL_RATE_OF_RETURN_MESSAGE, rateOfReturn * 100);
    }

    private static StringBuilder createFormattedLottosOutput(List<List<Integer>> lottos) {
        StringBuilder formattedLottoOutput = new StringBuilder();
        for (List<Integer> lotto : lottos) {
            ArrayList<Integer> copyLotto = new ArrayList<>(lotto);
            copyLotto.sort(Comparator.naturalOrder());
            formattedLottoOutput.append(copyLotto).append("\n");
        }
        return formattedLottoOutput;
    }

    private static void printLottosStatistics(Map<LottoResults, Integer> result) {
        System.out.printf(FIFTH_RANK_MESSAGE, result.getOrDefault(LottoResults.FIFTH, 0));
        System.out.printf(FOURTH_RANK_MESSAGE, result.getOrDefault(LottoResults.FOURTH, 0));
        System.out.printf(THIRD_RANK_MESSAGE, result.getOrDefault(LottoResults.THIRD, 0));
        System.out.printf(SECOND_RANK_MESSAGE, result.getOrDefault(LottoResults.SECOND, 0));
        System.out.printf(FIRST_RANK_MESSAGE, result.getOrDefault(LottoResults.FIRST, 0));
    }
}
