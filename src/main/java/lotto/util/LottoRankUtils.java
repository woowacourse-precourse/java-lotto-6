package lotto.util;

import lotto.domain.event.LottoRank;

public class LottoRankUtils {
    public static String getAllRank(LottoRank rank, int count) {
        String bonusDescription = rank.getMatchingBonusNumbers() > 0 ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%,d원) - %d개", rank.getMatchingNumbers(), bonusDescription, rank.getPrizeMoney(),
                count);
    }

    public static boolean matches(LottoRank rank, int matchingNumbers, boolean isBonusMatched) {
        if (rank.getMatchingNumbers() != matchingNumbers) {
            return false;
        }
        if (rank == LottoRank.SECOND) {
            return isBonusMatched;
        }
        return true;
    }
}
