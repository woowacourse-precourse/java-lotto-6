package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Statistic {
    private List<Lotto> lottos;
    private List<Integer> winner;
    private int bonusNumber;

    public Statistic(int bonusNumber, Lotto lotto) {
        lottos = new LinkedList<>();
        this.bonusNumber = bonusNumber;
        winner = lotto.getLottoNumbers();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Integer> checkRank() {
        int[] rank = new int[7];

        for (Lotto item : lottos) {
            List<Integer> lotto = item.getLottoNumbers();
            int sameCount = countSameNumber(winner, lotto);

            if (sameCount == 6) {
                rank[1] += 1;
            }
            else if (sameCount == 5) {
                if (checkBonusNumber(lotto)) {
                    rank[2] += 1;
                } else {
                    rank[3] += 1;
                }
            }
            else if (sameCount == 4) {
                rank[4] += 1;
            }
            else if (sameCount == 3) {
                rank[5] += 1;
            }
            else {
                rank[6] += 1;
            }
        }

        return Arrays.stream(rank).boxed()
                .collect(Collectors.toList());
    }

    public int countSameNumber(List<Integer> firstRank, List<Integer> lotto) {
        Set<Integer> winner = new HashSet<>(firstRank);
        int sameCount = 0;

        for (int number : lotto) {
            if (winner.contains(number)) {
                sameCount += 1;
            }
        }

        return sameCount;
    }

    public boolean checkBonusNumber(List<Integer> lotto) {
        return lotto.contains(bonusNumber);
    }
}
