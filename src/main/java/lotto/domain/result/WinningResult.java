package lotto.domain.result;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import lotto.domain.lotto.LottoMoney;

public class WinningResult {

    private final Map<WinningRank, Integer> winningResult;

    public WinningResult(Map<WinningRank, Integer> winningResult) {
        this.winningResult = winningResult;
    }


    //todo : 불변 테스트
    public Map<WinningRank, Integer> getResult() {
        return Collections.unmodifiableMap(winningResult);
    }
}
