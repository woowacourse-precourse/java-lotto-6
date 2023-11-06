package lotto.domain.lotto.userLotto;

import lotto.domain.*;
import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCondition;

import java.util.List;

public class UserLotto {

    private final PurchasePrice purchasePrice;
    private final Lottos lottos;

    public UserLotto(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
        this.lottos = new Lottos(purchasePrice / LottoCondition.PRICE.getValue());
    }

    public WinningResult calculateWinningResult(AnswerLotto answerLotto) {
        List<Ranking> rankings = lottos.calculateWinningResult(answerLotto);
        return new WinningResult(rankings, purchasePrice.getPurchasePrice());
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
