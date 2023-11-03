package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class MainModel implements LottoJudge{
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

    public int[] judgeLotto(Lotto userLotto, int bonusNumber) {
        int[] result = new int[RANK_INDEX];

        for (Lotto computerLotto : computerLottos) {
            addRank(result, compareNumbers(new LinkedHashSet<>(computerLotto.getNumbers()),
                    new LinkedHashSet<>(userLotto.getNumbers()),
                    bonusNumber));
        }
        return result;
    }

    private void addRank(int[] result, Rank rank) {
        if(rank != null) {
            switch (rank) {
                case FIRST -> result[4]++;
                case SECOND -> result[3]++;
                case THIRD -> result[2]++;
                case FOURTH -> result[1]++;
                case FIFTH -> result[0]++;
            }
        }
    }

    private Rank compareNumbers(Set<Integer> computerNumbers, Set<Integer> userNumbers,
                                int bonusNumber) {
        computerNumbers.retainAll(userNumbers);
        return getRank(computerNumbers.size(), computerNumbers.contains(bonusNumber));
    }

    private Rank getRank(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch);
        if (rank == Rank.SECOND && !matchBonus) {
            return Rank.THIRD;
        }
        return rank;
    }
}
