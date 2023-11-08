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

/**
 * 로또의 결과를 포함하는 WinResult 역할의 개념 객체를 나타내는 클래스입니다.
 */
public class LottoWinResult implements WinResult {
        private Map<LottoRank, Integer> ranks;

        private BigDecimal rateOfReturn;

        /**
         * LottoWinResult 의 생성자 함수로 로또 리스트와 정답, 보너스 를 주입받습니다.
         * 주입 받은 값을 바탕으로 결과를 계산합니다.
         * @param lottoEntry  로또 리스트
         * @param answer      정답 로또
         * @param magicNumber 보너스 숫자
         */
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

        /**
         * 로또의 등수를 계산합니다.
         *
         * @param lottoEntry  로또 리스트
         * @param answer      정답 로또
         * @param magicNumber 보너스 숫자
         */
        private void calculateRanks(List<Lotto> lottoEntry, Lotto answer, int magicNumber) {
                lottoEntry.forEach(lotto -> {
                        long count = lotto.countMatchNumber(answer);
                        LottoRank rank = LottoRank.getRank(count);
                        rank = checkMagicNumber(magicNumber, lotto, count, rank);

                        if (!rank.equals(NONE)) {
                                ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
                        }
                });
        }

        /**
         * 만약 맞춘 개수가 5개라면 보너스 숫자를 포함하는지 검사합니다.
         * 만약 포함하면 rank 를 SECOND 할당하여 반환합니다.
         *임
         * @param magicNumber 보너스 숫자
         * @param lotto       로또
         * @param count       맞춘 개수
         * @param rank        등수
         * @return 등수
         */
        private static LottoRank checkMagicNumber(int magicNumber, Lotto lotto, long count, LottoRank rank) {
                if (count == 5 && lotto.hasNumber(magicNumber)) {
                        rank = SECOND;
                }

                return rank;
        }

        /**
         * 수익률을 계산합니다. 수익률은 소수점 2째자리에서 반올림합니다.
         *
         * @param numOfLottoEntry 구매한 로또 수
         */
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

        /**
         * 로또의 총 수익률을 반환합니다.
         *
         * @return 총 수익률
         */
        public BigDecimal getRateOfReturn() {
                return rateOfReturn;
        }
}
