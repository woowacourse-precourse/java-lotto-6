package lotto.application;

import lotto.domain.Lotto;
import lotto.global.constant.enums.MatchResultType;

import java.util.List;
import java.util.Map;

public class LottoGameInfo {

    /**
     * @param quantity 구매 수량
     * @param lottos 발행 로또
     */
    public record PurchaseStatus(
            long quantity,
            List<Lotto> lottos
    ) {}

    /**
     * @param resultBoard 로또 게임 점수 보드
     */
    public record MatchResult(
            Map<MatchResultType, Long> resultBoard
    ) {
    }

    /**
     * @param inputAmount 투입 금액
     * @param totalReward 전체 상금액
     */
    public record RevenueInfo(
            long inputAmount,
            long totalReward
    ) {
    }

}
