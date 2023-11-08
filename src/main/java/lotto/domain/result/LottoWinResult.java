package lotto.domain.result;

import static lotto.domain.result.LottoRank.FIFTH;
import static lotto.domain.result.LottoRank.FIRST;
import static lotto.domain.result.LottoRank.FOURTH;
import static lotto.domain.result.LottoRank.SECOND;
import static lotto.domain.result.LottoRank.THIRD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.seller.TicketPrice;

/**
 * 로또의 결과를 포함하는 WinResult 역할의 개념 객체를 나타내는 클래스입니다.
 */
public class LottoWinResult implements WinResult {
        private final Map<LottoRank, Integer> ranks = new HashMap<>() {{
                put(FIRST, 0);
                put(SECOND, 0);
                put(THIRD, 0);
                put(FOURTH, 0);
                put(FIFTH, 0);
        }};

        private BigDecimal rateOfReturn;

        public LottoWinResult(List<Lotto> lottoEntry, Lotto answer, int magicNumber) {
                calculateRanks(lottoEntry, answer, magicNumber);
                calculateRateOfReturn(lottoEntry.size());
        }

        /**
         * 로또의 등수를 계산합니다.
         *
         * @param lottoEntry  로또 리스트
         * @param answer      당첨 번호
         * @param magicNumber 보너스 숫자
         */
        private void calculateRanks(List<Lotto> lottoEntry, Lotto answer, int magicNumber) {
                lottoEntry.forEach(lotto -> {
                        long count = lotto.countMatchNumber(answer);
                        LottoRank rank = LottoRank.getRank(count);
                        if (count == 5 && lotto.hasNumber(magicNumber)) {
                                rank = SECOND;
                        }

                        ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
                });
        }


        /**
         * 수익률을 계산합니다. 수익률은 소수점 2째자리에서 반올림합니다.
         *
         * @param numOfLottoEntry 구매한 로또 수
         */
        private void calculateRateOfReturn(long numOfLottoEntry) {
                BigDecimal payment = calcTotalPayment(numOfLottoEntry);
                BigDecimal winnings = calcTotalWinnings();
                rateOfReturn = winnings.divide(payment, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        }

        private BigDecimal calcTotalWinnings() {
                return ranks.keySet().stream()
                        .map(key -> key.getPrizes().multiply(BigDecimal.valueOf(ranks.get(key))))
                        .reduce(BigDecimal::add).orElseThrow();
        }

        private static BigDecimal calcTotalPayment(long numOfLottoEntry) {
                return TicketPrice.COMMON.getPrice().multiply(BigDecimal.valueOf(numOfLottoEntry));
        }

        public Map<LottoRank, Integer> getRanks() {
                return ranks;
        }

        public BigDecimal getRateOfReturn() {
                return rateOfReturn;
        }
}
