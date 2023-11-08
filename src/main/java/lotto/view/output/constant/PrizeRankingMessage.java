package lotto.view.output.constant;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.prize.ranking.rule.PrizeRanking;

public enum PrizeRankingMessage {
    FIRST(PrizeRanking.FIRST, "%d개 일치 (%s원) - %d개"),
    SECOND(PrizeRanking.SECOND, "%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    THIRD(PrizeRanking.THIRD, "%d개 일치 (%s원) - %d개"),
    FOURTH(PrizeRanking.FOURTH, "%d개 일치 (%s원) - %d개"),
    FIFTH(PrizeRanking.FIFTH, "%d개 일치 (%s원) - %d개"),
    UNKNOWN(null, null);

    private static final Map<PrizeRanking, PrizeRankingMessage> prizeRankings = Arrays.stream(values())
            .collect(
                    Collectors.toMap
                            (
                                    PrizeRankingMessage::getPrizeRanking,
                                    Function.identity()
                            )
            );
    private final PrizeRanking prizeRanking;
    private final String messageFormat;

    PrizeRankingMessage(
            final PrizeRanking prizeRanking,
            final String messageFormat
    ) {
        this.prizeRanking = prizeRanking;
        this.messageFormat = messageFormat;
    }

    public static PrizeRankingMessage find(final PrizeRanking prizeRanking) {
        return Optional.ofNullable(prizeRankings.get(prizeRanking)).orElse(UNKNOWN);
    }

    public PrizeRanking getPrizeRanking() {
        return prizeRanking;
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
