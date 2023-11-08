package lotto;

import static lotto.ErrorMessages.LOTTO_WITH_BONUS_DUPLICATION;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, int bonus) {
        if (lotto.getLottoNumbers().contains(bonus)) {
            throw new IllegalArgumentException(LOTTO_WITH_BONUS_DUPLICATION);
        }
    }

    public Rank match(Lotto userLotto) {
        List<Integer> userLottoNumbers = new ArrayList<>(userLotto.getLottoNumbers());

        boolean hasBonus = userLottoNumbers.contains(bonus);
        userLottoNumbers.retainAll(lotto.getLottoNumbers());

        return Rank.getRank(userLottoNumbers.size(), hasBonus);
    }
}
