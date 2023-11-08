package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Dto.BoughtLottosDto;
import lotto.constant.constants.Prize;

public class Lottos {
    private final List<Lotto> Lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        this.Lottos.add(lotto);
    }

    public int size() {
        return this.Lottos.size();
    }

    public int calculateMatched(Lotto winningLotto, Integer bonusNumber, Prize prize) {
        if (prize.equals(Prize.FIVE_AND_BONUS_MATCHED)) {
            return calculateBonusMatched(winningLotto, bonusNumber, prize);
        }
        int won = 0;
        for (Lotto lotto : this.Lottos) {
            int compare = winningLotto.compare(lotto);
            if (compare == prize.getMatched()) {
                won++;
            }
            if (compare == 5 && compare == prize.getMatched() && lotto.contains(bonusNumber)) { // 중복 방지
                won--;
            }
        }
        return won;
    }

    private int calculateBonusMatched(Lotto winningLotto, Integer bonusNumber, Prize prize) {
        int matched = 0;
        for (Lotto lotto : Lottos) {
            if (winningLotto.compare(lotto) == prize.getMatched() && lotto.contains(bonusNumber)) {
                matched++;
            }
        }
        return matched;
    }

    public BoughtLottosDto toDto() {
        List<List<Integer>> result = new ArrayList<>();
        for (Lotto lotto : Lottos) {
            result.add(lotto.getNumbers());
        }
        return new BoughtLottosDto(result);
    }
}