package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class MainModel {
    private List<Lotto> computerLottos;
    private final static int RANK_INDEX = 5;

    public MainModel(List<Lotto> computerLottos) {
        this.computerLottos = computerLottos;
    }

    public int[] judgeLotto(Lotto userLotto, int bonusNumber) {
        int[] result = new int[RANK_INDEX];

        for (Lotto computerLotto : computerLottos) {
            addRank(result, compareNumbers(new LinkedHashSet<>(computerLotto.getNumbers()),
                    new LinkedHashSet<>(computerLotto.getNumbers()),
                    bonusNumber));
        }
        return result;
    }

    private void addRank(int[] result, Rank rank)
    {
        switch (rank)
        {
            case FIRST -> result[0]++;
            case SECOND -> result[1]++;
            case THIRD -> result[2]++;
            case FOURTH -> result[3]++;
            case FIFTH -> result[4]++;
        }
    }

    private Rank compareNumbers(Set<Integer> computerNumbers, Set<Integer> userNumbers,
                                int bonusNumber) {
        int countOfMatch = 0;
        computerNumbers.retainAll(userNumbers);
        return getRank(countOfMatch,computerNumbers.contains((Integer)bonusNumber));
    }

    private Rank getRank(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch);
        if (rank == Rank.SECOND && !matchBonus) {
            return Rank.THIRD;
        }
        return rank;
    }
}
