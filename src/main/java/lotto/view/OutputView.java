package lotto.view;

import static lotto.message.ResultMessage.RESULT_MESSAGE_3_MATCH;
import static lotto.message.ResultMessage.RESULT_MESSAGE_4_MATCH;
import static lotto.message.ResultMessage.RESULT_MESSAGE_5_BONUS_MATCH;
import static lotto.message.ResultMessage.RESULT_MESSAGE_5_MATCH;
import static lotto.message.ResultMessage.RESULT_MESSAGE_6_MATCH;
import static lotto.message.ResultMessage.RESULT_MESSAGE_HEADER;
import static lotto.message.ResultMessage.RESULT_MESSAGE_SEPARATOR;
import static lotto.message.ResultMessage.RESULT_MESSAGE_TOTAL_INCOME;

import java.util.List;
import java.util.Map;
import lotto.message.LottoType;

public class OutputView {
    StringBuilder result;

    public String printToPrizeDetails(Map<String, Integer> stats, double earningRate) {
        result = new StringBuilder();

        result.append(RESULT_MESSAGE_HEADER.getMessage()).append("\n");
        result.append(RESULT_MESSAGE_SEPARATOR.getMessage()).append("\n");
        result.append(RESULT_MESSAGE_3_MATCH.getMessage())
                .append(stats.get(LottoType.FIVE_THOUSAND.getPrizeCost()))
                .append("개\n");
        result.append(RESULT_MESSAGE_4_MATCH.getMessage())
                .append(stats.get(LottoType.FIFTY_THOUSAND.getPrizeCost()))
                .append("개\n");
        result.append(RESULT_MESSAGE_5_MATCH.getMessage())
                .append(stats.get(LottoType.ONE_HALF_MILLION.getPrizeCost()))
                .append("개\n");
        result.append(RESULT_MESSAGE_5_BONUS_MATCH.getMessage())
                .append(stats.get(LottoType.THIRTY_MILLION.getPrizeCost()))
                .append("개\n");
        result.append(RESULT_MESSAGE_6_MATCH.getMessage())
                .append(stats.get(LottoType.TWO_HUNDRED_MILLION.getPrizeCost()))
                .append("개\n");
        result.append(RESULT_MESSAGE_TOTAL_INCOME.getMessage())
                .append(earningRate)
                .append("%입니다.");

        return result.toString();
    }

    public String printToBuyLotto(List<List<Integer>> buyLottoNumbers, int buyCount) {
        result = new StringBuilder();
        result.append(buyCount).append("개를 구매했습니다.").append("\n");

        for (List<Integer> lottoNumbers : buyLottoNumbers) {
            result.append(lottoNumbers).append("\n");
        }

        return result.toString();
    }
}
