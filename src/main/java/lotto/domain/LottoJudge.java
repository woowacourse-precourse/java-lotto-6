package lotto.domain;

import lotto.domain.wrapper.BuyLottos;
import lotto.domain.wrapper.Lotto;
import lotto.domain.wrapper.LottoResult;
import lotto.domain.wrapper.WinLottoWithBonus;
import lotto.handler.LottoHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.handler.ConstantsHandler.*;
import static lotto.handler.LottoHandler.FIVE;
import static lotto.handler.LottoHandler.FIVE_WITH_BONUS;

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

    public LottoResult matchLottoHandler() {
        Map<LottoHandler, Integer> lottoResult = new HashMap<>();

        for (Lotto buyLotto : buyLottos.getBuyLottos()) {
            List<Integer> sortBuyLotto = buyLotto.sortLottoNumbers();
            int matchingCount = compareLotto(sortBuyLotto, winLottoWithBonus.getWinningLotto());
            LottoHandler lottoHandler = LottoHandler.getLottoHandler(matchingCount);

            if (lottoHandler == FIVE) {
                lottoHandler = checkBonus(sortBuyLotto, winLottoWithBonus.getBonusNumber());
            }
            lottoResult.put(lottoHandler, lottoResult.getOrDefault(lottoHandler, DEFAULT_VALUE) + PLUS_NUMBER);
        }

        return LottoResult.create(lottoResult);
    }

    private int compareLotto(List<Integer> sortBuyLotto, List<Integer> winningLotto) {
        int count = INIT_INT_VALUE;

        for (int winNumber : winningLotto) {
            if (sortBuyLotto.contains(winNumber)) {
                count += PLUS_NUMBER;
            }
        }

        return count;
    }

    private LottoHandler checkBonus(List<Integer> sortBuyLotto, int bonusNumber) {
        if (sortBuyLotto.contains(bonusNumber)) {
            return FIVE_WITH_BONUS;
        }

        return FIVE;
    }
}
