package lotto.dto.response;

import lotto.config.LottoMessage;
import lotto.config.Rank;

import java.util.Map;

public class LottoResultsDto {

    private final Map<Rank, Long> results;

    private LottoResultsDto(Map<Rank, Long> results) {
        this.results = results;
    }

    public static LottoResultsDto of(Map<Rank, Long> results) {
        return new LottoResultsDto(results);
    }

    public String formatResults() {
        StringBuilder builder = new StringBuilder(LottoMessage.WINNING_STATISTICS_HEADER.getMessage());

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                builder.append(getFormattedResultLine(rank, results.getOrDefault(rank, 0L)));
            }
        }

        return builder.toString();
    }

    public long calculateTotalPrize() {
        return results.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.NONE)
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    private String getFormattedResultLine(Rank rank, Long count) {
        String prizeMoney = rank.getPrizeMoneyFormatted();
        String rankMessage = getRankMessage(rank);

        return String.format(LottoMessage.MATCH_RESULT.getMessage(), rankMessage, prizeMoney, count);
    }

    private String getRankMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return LottoMessage.MATCH_COUNT_WITH_BONUS.getFormattedMessage(rank.getMatchCount());
        }
        return LottoMessage.MATCH_COUNT.getFormattedMessage(rank.getMatchCount());
    }
}
