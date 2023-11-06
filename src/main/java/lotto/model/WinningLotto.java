package lotto.model;

import java.util.List;
import lotto.dto.MatchCounterDTO;

public class WinningLotto{
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public MatchCounterDTO countMatchesWholeNumber(Lotto targetLotto) {
        Integer countMatchesLotto = lotto.countMatchesNumber(targetLotto);
        Integer countMatchesBonus = 0;

        if (countMatchesLotto == 5) {
            countMatchesBonus = bonus.countMatchesBonus(targetLotto);
        }

        return new MatchCounterDTO(countMatchesLotto, countMatchesBonus);
    }
}
