package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private Map<WinningResult, Integer> winningStatistics = new HashMap<>();
    private BigDecimal revenueRate = BigDecimal.ZERO;

    private WinningResult(Lottos userLottos, WinningLotto winningLotto){
        setWinningStatistics(userLottos, winningLotto);
        setRevenueRate(userLottos, winningLotto);
    }

    public static WinningResult from(Lottos userLottos, WinningLotto winningLotto){
        return new WinningResult(userLottos, winningLotto);
    }

    private void setWinningStatistics(Lottos userLottos, WinningLotto winningLotto){

    }

    private void setRevenueRate(Lottos userLottos, WinningLotto winningLotto){

    }
}
