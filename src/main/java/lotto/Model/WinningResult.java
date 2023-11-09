package lotto.Model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<Winning, Integer> winningResult;

    public WinningResult(){
        winningResult = new EnumMap<Winning, Integer>(Winning.class);
        Arrays.stream(Winning.values())
                .forEach(winning -> winningResult.put(winning,0));
    }

    public void calcWinningResult(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Winning winning = Winning.getWinning(lotto.getMatchLottoNumber(winningLotto),
                    lotto.isContain(winningLotto.getBonusNumber()));
            updateWinningCount(winning);
        }
    }

    private void updateWinningCount(Winning winning) {
        winningResult.put(winning, winningResult.get(winning) + 1);
    }

    public Integer getWinningCount(Winning winning) {
        return winningResult.get(winning);
    }
}
