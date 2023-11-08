package lotto.domain.result;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 로또의 결과를 포함하는 WinResult 역할의 책임을 정의한 인터페이스입니다.
 */
public interface WinResult {
        /**
         * 로또 결과를 종합한 등수 정보를 반환합니다.
         * @return 로또 등수 결과
         */
        Map<LottoRank, Integer> getRanks();

        /**
         * 총 수익률을 반환합니다.
         * @return 총 수익률
         */
        BigDecimal getRateOfReturn();
}
