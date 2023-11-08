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
        buyLotto();
    }
    /* getter */
    public List<Lotto> getUserLottos() {
        return this.lottos;
    }
    /* 구매 금액 상 가능한 만큼의 로또를 구매 */
    public void buyLotto() {
        Lotto lotto;
        for (int i = 0; i < this.lottoCount; ++i) {
            try {
                lotto = new Lotto(getLottoNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] 로또 번호는 여섯 개로 이루어져야 합니다.");
                i--;
                continue;
            }
            this.lottos.add(lotto);
        }
    }
}
