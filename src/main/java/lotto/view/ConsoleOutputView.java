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
import lotto.domain.dto.WinningResultDto;
import lotto.domain.entity.Ranking;
import lotto.domain.dto.PurchaseDto;
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
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking != Ranking.No)
                .map(ranking
                        -> String.format("%s개 일치 (%s원) - %d개",
                        ranking.getMatchCount(),
                        StringUtil.formatByThousandSeparator(ranking.getPrizeAmount()),
                        rankingCounts.get(ranking)))
                .collect(Collectors.joining("\n"));
    }

    private String buildRateOfReturnMessage(double rateOfReturn) {
        return RATE_OF_RETURN_MESSAGE_HEAD.getMessage()
                + DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimalWithPercent(
                        rateOfReturn)
                + RATE_OF_RETURN_MESSAGE_TAIL.getMessage();
    }
}
