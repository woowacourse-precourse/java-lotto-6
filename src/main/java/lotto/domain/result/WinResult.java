package lotto.domain.result;

import java.math.BigDecimal;
import java.util.Map;

public interface WinResult {
        Map<LottoRank, Integer> getRanks();

        BigDecimal getRateOfReturn();
}
