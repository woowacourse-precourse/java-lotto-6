package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int lottoCount;
    private final List<Lotto> lottos;
    private Lotto userLotto;
    private int bonusNumber;

    public User(int price) {
        this.lottoCount = price / Const.priceUnit;
        this.lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.createWinningNumbers());
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setUserLotto(Lotto lotto) {
        this.userLotto = lotto;
    }

    public Lotto getUserLotto() {
        return userLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
