package lotto.domain.result;

import static lotto.domain.result.LottoRank.FIFTH;
import static lotto.domain.result.LottoRank.FIRST;
import static lotto.domain.result.LottoRank.FOURTH;
import static lotto.domain.result.LottoRank.NONE;
import static lotto.domain.result.LottoRank.SECOND;
import static lotto.domain.result.LottoRank.THIRD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.seller.TicketPrice;

public class LottoWinResult implements WinResult {
        private Map<LottoRank, Integer> ranks;
        private BigDecimal rateOfReturn;

        public LottoWinResult(List<Lotto> lottoEntry, Lotto answer, int magicNumber) {
                initLottoResultRank();
                calculateRanks(lottoEntry, answer, magicNumber);
                calculateRateOfReturn(lottoEntry.size());
        }

        private void initLottoResultRank() {
                ranks = new HashMap<>() {{
                        put(FIRST, 0);
                        put(SECOND, 0);
                        put(THIRD, 0);
                        put(FOURTH, 0);
                        put(FIFTH, 0);
                }};
        }

        private void calculateRanks(List<Lotto> lottoEntry, Lotto answer, int magicNumber) {
                lottoEntry.forEach(lotto -> {
                        long count = lotto.matchCount(answer);
                        LottoRank rank = LottoRank.getRank(count);
                        rank = checkMagicNumber(magicNumber, lotto, count, rank);

                        if (!rank.equals(NONE)) {
                                ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
                        }
                });
        }

        private static LottoRank checkMagicNumber(int magicNumber, Lotto lotto, long count, LottoRank rank) {
                if (count == 5 && lotto.hasNumber(magicNumber)) {
                        rank = SECOND;
                }

                return rank;
        }

        private void calculateRateOfReturn(long numOfLottoEntry) {
                BigDecimal payment = TicketPrice.COMMON.getPrice().multiply(BigDecimal.valueOf(numOfLottoEntry));
                BigDecimal gain = ranks.keySet().stream()
                        .map(key -> key.getPrizes().multiply(BigDecimal.valueOf(ranks.get(key))))
                        .reduce(BigDecimal::add).orElseThrow();

                rateOfReturn = gain.divide(payment, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        }

        public Map<LottoRank, Integer> getRanks() {
                return ranks;
        }

        public BigDecimal getRateOfReturn() {
                return rateOfReturn;
        }
}
