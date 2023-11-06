package lotto.model;

import lotto.config.LottoMessage;
import lotto.config.Rank;
import lotto.dto.request.WinningNumbersDto;
import lotto.dto.response.LottoResultsDto;
import lotto.dto.response.LottoTicketsDto;
import lotto.util.ProfitCalculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    private LottoService() {
    }

    public static LottoService getInstance() {
        return new LottoService();
    }

    public LottoResultsDto calculateResults(LottoTicketsDto lottoTicketsDto, WinningNumbersDto winningNumbersDto, Money spentMoney) {
        Lottos lottoTickets = lottoTicketsDto.getLottoTickets();
        List<Lotto> lottos = lottoTickets.getLottoTickets();

        Map<Rank, Long> lottoStream = lottos.stream()
                .map(lotto -> determineRank(lotto, winningNumbersDto.getNumbers(), winningNumbersDto.getBonus()))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));

        LottoResults lottoResults = LottoResults.from(lottoStream);

        String formattedResults = formatResults(lottoResults);
        float profitRate = calculateProfitRate(spentMoney, lottoResults);

        return new LottoResultsDto(formattedResults, profitRate);
    }

    private Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        return Rank.valueOf(matchCount, bonusMatch);
    }

    private String formatResults(LottoResults lottoResults) {
        StringBuilder builder = new StringBuilder();

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                builder.append(
                        getFormattedResultLine(
                                rank,
                                lottoResults.getResults().getOrDefault(rank, 0L)
                        ));
            }
        }

        return builder.toString();
    }

    private String getFormattedResultLine(Rank rank, Long count) {
        String rankMessage = getRankMessage(rank);
        String matchResultMessage = getMatchResultMessage(rank, count);

        return rankMessage + matchResultMessage;
    }

    private String getMatchResultMessage(Rank rank, Long count) {
        String prizeMoney = rank.getPrizeMoneyFormatted();
        return LottoMessage.MATCH_RESULT.getFormattedMessage(prizeMoney, count);
    }

    private String getRankMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return LottoMessage.MATCH_COUNT_WITH_BONUS.getFormattedMessage(rank.getMatchCount());
        }
        return LottoMessage.MATCH_COUNT.getFormattedMessage(rank.getMatchCount());
    }

    private float calculateProfitRate(Money money, LottoResults lottoResults) {
        int totalCost = money.getAmount();
        long totalPrize = lottoResults.calculateTotalPrize();
        return ProfitCalculator.calculateLottoReturnRate(totalCost, totalPrize);
    }
}
