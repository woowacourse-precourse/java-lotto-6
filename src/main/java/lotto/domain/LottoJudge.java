package lotto.domain;

import lotto.domain.wrapper.BuyLottos;
import lotto.domain.wrapper.Lotto;
import lotto.domain.wrapper.WinLottoWithBonus;
import lotto.handler.LottoHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoJudge {

    private final BuyLottos buyLottos;
    private final WinLottoWithBonus winLottoWithBonus;

    private LottoJudge(BuyLottos buyLottos, WinLottoWithBonus winLottoWithBonus) {
        this.buyLottos = buyLottos;
        this.winLottoWithBonus = winLottoWithBonus;
    }

    public static LottoJudge create(BuyLottos buyLottos, WinLottoWithBonus winLottoWithBonus) {
        return new LottoJudge(buyLottos, winLottoWithBonus);
    }

    public void matchLottoHandler() {
        Map<LottoHandler, Integer> lottoResult = new HashMap<>();

        for (Lotto buyLotto : buyLottos.getBuyLottos()) {

        }
    }

    private int compareLotto(Lotto buyLotto, List<Integer> winningLotto) {
        int count = 0;

        for (int winNumber : winningLotto) {
            if (buyLotto.sortLottoNumbers().contains(winNumber)) {
                count += 1;
            }
        }

        return count;
    }
}
