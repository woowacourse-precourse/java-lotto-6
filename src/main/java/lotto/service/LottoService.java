package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoGameResult;
import lotto.constant.LottoRank;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.NumericConstant.LOTTO_PRICE;

public class LottoService {

    private long totalPurchaseAmount = 0;
    private List<Lotto> userLottos = new ArrayList<>();
    private LottoFactory lottoFactory;

    public LottoService(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public List<Lotto> buyLotto(int money) {
        totalPurchaseAmount += money;
        int count = money / LOTTO_PRICE;

        userLottos = lottoFactory.createLottos(count);
        return userLottos;
    }

    public LottoGameResult getResultOfLottos(Lotto winningLotto, int bonusNumber) {
        LottoGameResult lottoGameResult = new LottoGameResult(totalPurchaseAmount);

        for (Lotto userLotto : userLottos) {
            LottoRank rank = userLotto.matching(winningLotto, bonusNumber);
            lottoGameResult.add(rank);
        }

        return lottoGameResult;
    }
}
