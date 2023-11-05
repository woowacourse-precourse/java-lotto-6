package lotto.application;

import lotto.domain.Lotto;
import lotto.global.constant.enums.MatchResultType;

import java.util.List;
import java.util.Map;

public class LottoGameInfo {

    public record PurchaseStatus(
            long quantity,
            List<Lotto> lottos
    ) {}

    public record MatchResult(
            Map<MatchResultType, Long> resultBoard
    ) {
    }

    public record RevenueInfo(
            long inputAmount,
            long totalReward
    ) {
    }


}
