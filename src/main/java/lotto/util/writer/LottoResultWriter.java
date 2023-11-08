package lotto.util.writer;

import static lotto.domain.result.LottoRank.FIFTH;
import static lotto.domain.result.LottoRank.FIRST;
import static lotto.domain.result.LottoRank.FOURTH;
import static lotto.domain.result.LottoRank.SECOND;
import static lotto.domain.result.LottoRank.THIRD;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.result.LottoRank;
import lotto.domain.result.WinResult;
import lotto.util.Logger;

public class LottoResultWriter {
        public static void write(WinResult result) {
                Map<LottoRank, Integer> ranks = result.getRanks();
                BigDecimal rateOfReturn = result.getRateOfReturn();
                Logger.info("\n당첨 통계\n---");

                for (LottoRank rank : List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST)) {
                        String priceFormat = String.format("%,d", rank.getPrizes().longValue());
                        Logger.info(rank + " (" + priceFormat + "원) - " + ranks.get(rank) + "개");
                }

                Logger.info("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
        }
}
