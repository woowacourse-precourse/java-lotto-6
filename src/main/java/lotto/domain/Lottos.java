package lotto.domain;

import java.util.List;

public class Lottos {

    private Lotto lotto;
    private Bonus bonus;

    public Lottos() {
    }

    public Lottos(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public void collectLottoNumbers(User user, Lotto lotto, Bonus bonus) {
        user.storePurchasedLotto(new Lottos(lotto, bonus));
    }

    public List<Integer> purchaseLottoNumber(){
        return lotto.lottoNumbers();
    }
}
