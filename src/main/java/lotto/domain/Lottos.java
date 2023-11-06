package lotto.domain;

import java.util.List;

public class Lottos {

    private Lotto lotto;

    public Lottos() {
    }

    public Lottos(Lotto lotto) {
        this.lotto = lotto;
    }

    public void collectLottoNumbers(User user, Lotto lotto) {
        user.storePurchasedLotto(new Lottos(lotto));
    }

    public List<Integer> purchaseLottoNumber(){
        return lotto.lottoNumbers();
    }
}
