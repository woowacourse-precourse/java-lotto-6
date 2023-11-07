package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        List<Integer> userLottoNumbers = new ArrayList<>(userLotto.getLottoNumbers());

        boolean hasBonus = userLottoNumbers.contains(bonus);
        userLottoNumbers.retainAll(lotto.getLottoNumbers());

        return Rank.getRank(userLottoNumbers.size(), hasBonus);
    }
}
