package lotto.model;

import static lotto.constants.MarksAndConstants.FIVE_SAME_NUM;
import static lotto.constants.MarksAndConstants.START_INDEX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.constants.LottoRanks;

public class Comparing {

    private final Lotto lotto;
    private final int bonusNum;
    private final List<Integer> sameNumCount;
    private final List<Boolean> secondOrNot;

    public Comparing(Lotto lotto, int bonusNum) {
        this.lotto = lotto;
        this.bonusNum = bonusNum;
        this.sameNumCount = new ArrayList<>();
        this.secondOrNot = new ArrayList<>();
    }

    public void compareAllToWinningNum(List<List<Integer>> purchasedLotto) {
        setBeforeComparing(purchasedLotto);
        for (int index = START_INDEX; index < purchasedLotto.size(); index++) {
            compareEachToWinningNum(purchasedLotto, index);
        }
    }

    private void setBeforeComparing(List<List<Integer>> purchasedLotto) {
        sameNumCount.addAll(Collections.nCopies(purchasedLotto.size(), 0));
        secondOrNot.addAll(Collections.nCopies(purchasedLotto.size(), false));
    }

    private void compareEachToWinningNum(List<List<Integer>> purchasedLotto, int index) {
        List<Integer> eachLotto = purchasedLotto.get(index);
        setEachComparingResult(index, eachLotto);
    }

    private void setEachComparingResult(int index, List<Integer> eachLotto) {
        int sameCount = countSameNumber(eachLotto, lotto.getWinningNumbers());
        sameNumCount.set(index, sameCount);
        secondOrNot.set(index, isLottoRankSecond(sameCount, eachLotto));
    }

    public int countSameNumber(List<Integer> eachLotto, List<Integer> winningNum) {
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

    public Map<LottoRanks, Integer> getComparingResult(int quantity) {
        Map<LottoRanks, Integer> result = LottoRanks.getEnumMap();
        for (int i = START_INDEX; i < quantity; i++) {
            LottoRanks key = LottoRanks.findRank(sameNumCount.get(i), secondOrNot.get(i));
            result.put(key, result.get(key) + 1);
        }
        return result;
    }
}
