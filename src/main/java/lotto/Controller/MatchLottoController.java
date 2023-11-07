package lotto.Controller;

import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.WinsCount;

public class MatchLottoController {

    private final WinsCount winsCount;

    public MatchLottoController(List<Lotto> lottos, List<Integer> winningNumber,int bonus) {
        winsCount = new WinsCount(lottos,winningNumber,bonus);
    }

    public List<Integer> getWinsCount() {
        return winsCount.getWinsCount();
    }
}
