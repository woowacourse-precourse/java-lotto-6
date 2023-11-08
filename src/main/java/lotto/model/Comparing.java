package lotto.model;

import static lotto.constants.MarksAndConstants.FIVE_SAME_NUM;
import static lotto.constants.MarksAndConstants.START_INDEX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constants.LottoRanks;

public class Comparing {

    private final List<Integer> sameNumCount;
    private final List<Boolean> secondOrNot;
    private final Lotto winningLotto;
    private final int bonusNum;

    public Comparing(Lotto winningLotto, int bonusNum) {
        this.sameNumCount = new ArrayList<>();
        this.secondOrNot = new ArrayList<>();
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public Map<LottoRanks, Integer> getResult(List<List<Integer>> purchased) {
        compareWinningNumToAll(purchased);
        return makeResultTable(purchased);
    }

    private void compareWinningNumToAll(List<List<Integer>> purchased) {
        for (List<Integer> eachLotto : purchased) {
            compareWinningNumToEach(eachLotto);
        }
    }

    private void compareWinningNumToEach(List<Integer> eachLotto) {
        int sameCount = countSameNumber(eachLotto);
        sameNumCount.add(sameCount);
        secondOrNot.add(isLottoRankSecond(sameCount, eachLotto));
    }

    public int countSameNumber(List<Integer> eachLotto) {
        List<Integer> winningNum = winningLotto.getWinningNumbers();
        int sameCount = 0;
        for (Integer num : eachLotto) {
            if (winningNum.contains(num)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    public boolean isLottoRankSecond(int sameCount, List<Integer> eachLotto) {
        return sameCount == FIVE_SAME_NUM && eachLotto.contains(bonusNum);
    }

    public Map<LottoRanks, Integer> makeResultTable(List<List<Integer>> purchased) {
        Map<LottoRanks, Integer> result = LottoRanks.getEnumMap();
        for (int i = START_INDEX; i < purchased.size(); i++) {
            LottoRanks rank = LottoRanks.findRank(sameNumCount.get(i), secondOrNot.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }
}
