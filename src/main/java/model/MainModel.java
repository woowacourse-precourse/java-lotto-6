package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class MainModel {
    private List<Lotto> computerLottos;

    public MainModel(List<Lotto> computerLottos) {
        this.computerLottos = computerLottos;
    }

    public List<Integer> judgeLotto(Lotto userLotto, int bonusNumber) {
        List<Integer> result = new ArrayList<>();

        for (Lotto computerLotto : computerLottos) {
            Rank rank = compareNumbers(new LinkedHashSet<>(computerLotto.getNumbers()),
                    new LinkedHashSet<>(computerLotto.getNumbers()),
                    bonusNumber);
        }
    }

    private Rank compareNumbers(Set<Integer> computerNumbers, Set<Integer> userNumbers,
                                int bonusNumber) {
        int countOfMatch = 0;
        computerNumbers.retainAll(userNumbers);
        return getRank(countOfMatch,);
    }

    private Rank getRank(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch);
        if (rank == Rank.SECOND && !matchBonus) {
            return Rank.THIRD;
        }
        return rank;
    }
}
