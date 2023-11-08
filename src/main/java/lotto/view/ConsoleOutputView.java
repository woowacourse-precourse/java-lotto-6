package lotto.view;

import static lotto.messages.OutputMessages.PURCHASE_COUNT_MESSAGE;
import static lotto.messages.OutputMessages.RATE_OF_RETURN_MESSAGE_HEAD;
import static lotto.messages.OutputMessages.RATE_OF_RETURN_MESSAGE_TAIL;
import static lotto.messages.OutputMessages.THREE_DIVIDING_LINES_MESSAGE;
import static lotto.messages.OutputMessages.WINNING_STATISTICS_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.dto.PurchaseDto;
import lotto.domain.dto.WinningResultDto;
import lotto.domain.entity.Ranking;
import lotto.util.DoubleUtil;
import lotto.util.OutputUtil;
import lotto.util.StringUtil;

public class ConsoleOutputView implements OutputView {

    @Override
    public void outputPurchaseLottoList(PurchaseDto purchaseDto) {
        List<List<Integer>> lottos = purchaseDto.getPurchaseLottos();

        System.out.println(buildPurchaseCountMessage(lottos.size()));
        lottos.forEach(lotto -> System.out.println(lotto));
        OutputUtil.printEmptyLine();
    }

    private String buildPurchaseCountMessage(int count) {
        return count + PURCHASE_COUNT_MESSAGE.getMessage();
    }

    @Override
    public void outputWinningStatistics(WinningResultDto winningResultDto) {
        Map<Ranking, Integer> rankingCounts = winningResultDto.getRankings();
        double rateOfReturn = winningResultDto.getRateOfReturn();

        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(THREE_DIVIDING_LINES_MESSAGE.getMessage());

        System.out.println(buildRankingCountsMessage(rankingCounts));
        System.out.println(buildRateOfReturnMessage(rateOfReturn));
    }

    private String buildRankingCountsMessage(Map<Ranking, Integer> rankingCounts) {
        StringBuilder sb = new StringBuilder();

        rankingCounts.forEach(
                (ranking, rankingCount) -> sb.append(buildDescription(ranking,rankingCount)));

        return sb.toString();
    }

    private String buildDescription(Ranking ranking, int rankingCount) {
        if (ranking == Ranking.No) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(ranking.getMatchCount());
        sb.append("개 일치");

        if (ranking.isUsingBonusNumber()) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append(" (");
        sb.append(StringUtil.formatByThousandSeparator(ranking.getPrizeAmount()));
        sb.append("원");
        sb.append(") ");
        sb.append("- ");

        sb.append(rankingCount);
        sb.append("개");
        sb.append("\n");

        return sb.toString();
    }

    private String buildRateOfReturnMessage(double rateOfReturn) {
        return RATE_OF_RETURN_MESSAGE_HEAD.getMessage()
                + DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimalWithPercent(rateOfReturn)
                + RATE_OF_RETURN_MESSAGE_TAIL.getMessage();
    }
}
