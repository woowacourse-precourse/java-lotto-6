package lotto.domain;

import static lotto.domain.LottoGenerator.getLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int buyingPrice;
    private int lottoCount;
    private List<Lotto> lottos;

    public User(int buyingPrice) {
        this.buyingPrice = buyingPrice;
        this.lottoCount = buyingPrice / 1000;
        lottos = new ArrayList<Lotto>();
    }
    /* 구매 금액 상 가능한 만큼의 로또를 구매 */
    public void buyLotto() {
        for (int i = 0; i < this.lottoCount; ++i) {
            Lotto lotto = new Lotto(getLottoNumbers());
            lottos.add(lotto);
        }
    }
}
