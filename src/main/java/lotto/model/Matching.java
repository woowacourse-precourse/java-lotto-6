package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.constants.LottoRanks;

public class Matching {
    private final List<List<Integer>> purchasedLotto;
    private final Lotto winningNum;
    private final List<Integer> matchedLottoNum;
    private final List<Boolean> matchedBonusNum;

    public Matching(List<List<Integer>> purchasedLotto, Lotto winningNum) {
        this.purchasedLotto = purchasedLotto;
        this.winningNum = winningNum;
        this.matchedLottoNum = new ArrayList<>(Collections.nCopies(purchasedLotto.size(), 0));
        this.matchedBonusNum = new ArrayList<>(Collections.nCopies(purchasedLotto.size(),false));
    }

    public void compareToWinningNumbers(int bonusNum) {
        for (int i = 0; i < purchasedLotto.size(); i++) {
            List<Integer> singleLotto = purchasedLotto.get(i);
            matchedLottoNum.set(i, winningNum.countSameNumber(singleLotto));
            if (matchedLottoNum.get(i) == 5 && singleLotto.contains(bonusNum)) {
                matchedBonusNum.set(i, true);
            }
        }
    }
    public Map<LottoRanks, Integer> countLottoWinningResult(int quantity) {
        Map<LottoRanks, Integer> result = LottoRanks.getEnumMap();
        for (int i = 0; i < quantity; i++) {
            LottoRanks key = LottoRanks.findKey(matchedLottoNum.get(i), matchedBonusNum.get(i));
            result.put(key, result.get(key)+1);
        }
        return result;
    }
}
