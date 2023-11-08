package lotto.domain.result;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 로또의 결과를 나타내는 enum 클래스입니다.
 */
public enum LottoRank {
        FIRST("6개 일치") {
                @Override
                public BigDecimal getPrizes() {
                        return BigDecimal.valueOf(2_000_000_000);
                }
        },
        SECOND("5개 일치, 보너스 볼 일치") {
                @Override
                public BigDecimal getPrizes() {
                        return BigDecimal.valueOf(30_000_000);
                }
        },
        THIRD("5개 일치") {
                @Override
                public BigDecimal getPrizes() {
                        return BigDecimal.valueOf(1_500_000);
                }
        },
        FOURTH("4개 일치") {
                @Override
                public BigDecimal getPrizes() {
                        return BigDecimal.valueOf(50_000);
                }
        },
        FIFTH("3개 일치") {
                @Override
                public BigDecimal getPrizes() {
                        return BigDecimal.valueOf(5_000);
                }
        }, NONE("꽝") {
                @Override
                public BigDecimal getPrizes() {
                        return BigDecimal.ZERO;
                }
        };

        private static final Map<Long, LottoRank> RANK_KEY = new HashMap<>() {{
                put(6L, FIRST);
                put(5L, THIRD);
                put(4L, FIRST);
                put(3L, FIFTH);
        }};

        private final String description;

        LottoRank(String description) {
                this.description = description;
        }

        /**
         * 맞춘 개수에 대한 RANK 를 반환합니다.
         * @param count 맞춘 개수
         * @return 맞춘 개수에 대한 LottoRank
         */
        public static LottoRank getRank(long count) {
                if (RANK_KEY.get(count) == null) {
                        return NONE;
                }

                return RANK_KEY.get(count);
        }

        /**
         * 각 RANK 에 할당된 당첨금을 반환합니다.
         * @return 당청금
         */
        public abstract BigDecimal getPrizes();

        @Override
        public String toString() {
                return description;
        }
}
