package lotto.domain.result;

import java.math.BigDecimal;
import java.util.Map;

/**
 * WinResult 의 핵심 로직을 정의한 인터페이스입니다.
 */
public interface WinResult {
        /**
         * 등수 결과 를 반환합니다.
         *
         * @return 등수 결과
         */
        Map<LottoRank, Integer> getRanks();

        /**
         * 수익률을 반환합니다.
         *
         * @return 수익률
         */
        BigDecimal getRateOfReturn();
}
