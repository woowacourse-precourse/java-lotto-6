package lotto.domain;

import java.text.MessageFormat;
import java.util.Arrays;

public class LottoEnum {
    public enum LottoRank {
        FIRST(6, false, 2_000_000_000),
        SECOND(5, true, 30_000_000),
        THIRD(5, false, 1_500_000),
        FOURTH(4, false, 50_000),
        FIFTH(3, false, 5_000),
        MISS(0, false, 0);

        private final int matchCount;
        private final boolean bonusMatch;
        private final int prizeMoney;

        LottoRank(int matchCount, boolean bonusMatch, int prizeMoney) {
            this.matchCount = matchCount;
            this.bonusMatch = bonusMatch;
            this.prizeMoney = prizeMoney;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }

        public static LottoRank valueOf(int matchCount, boolean matchBonus) {
            return Arrays.stream(LottoRank.values())
                    .filter(rank -> rank.matchCount == matchCount)
                    .sorted((rank1, rank2) -> Boolean.compare(rank2.bonusMatch, rank1.bonusMatch))
                    .findFirst()
                    .orElse(MISS);
        }
        public String toString() {
            if (this == MISS) {
                return "꽝";
            }
            return MessageFormat.format("{0}개 일치{1} ({2}원)", matchCount, (bonusMatch ? ", 보너스 볼 일치" : ""), prizeMoney);
        }
    }

}
