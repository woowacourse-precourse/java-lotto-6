package model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.Lotto;

public class MainModel implements LottoJudge {
    private List<Lotto> computerLottos;
    private final static int RANK_INDEX = 5;

    public MainModel(List<Lotto> computerLottos) {
        this.computerLottos = computerLottos;
    }

    public List<Integer[]> getComputerLottos() {
        List<Integer[]> temp = new ArrayList<>();

        for (Lotto computerLotto : computerLottos) {
            List<Integer> list = computerLotto.getNumbers();
            Integer[] convertedToArray = list.toArray(new Integer[0]);
            temp.add(convertedToArray);
        }

        return temp;
    }

    public EnumMap<Rank, Integer> judgeLotto(Lotto userLotto, int bonusNumber) {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (Lotto computerLotto : computerLottos) {
            Rank rank = compareNumbers(result, computerLotto.getNumbers(), userLotto.getNumbers(),
                    bonusNumber);
            if(rank != null)
            {
                result.put(rank, result.getOrDefault(rank, 0) +1);
            }
        }
        return result;
    }

    private Rank compareNumbers(Map<Rank, Integer> result, List<Integer> computerNumbers,
                                List<Integer> userNumbers,
                                int bonusNumber) {
        userNumbers.retainAll(computerNumbers);
        return getRank(userNumbers.size(), computerNumbers.contains(bonusNumber));
    }

    private Rank getRank(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch);
        if (rank == Rank.THIRD && matchBonus) {
            return Rank.SECOND;
        }
        return rank;
    }
}
