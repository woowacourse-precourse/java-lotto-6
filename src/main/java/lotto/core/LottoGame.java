package lotto.core;

import java.util.*;
import lotto.util.LottoConst;
import lotto.util.RandomNumGenerator;
import lotto.util.Rank;

public class LottoGame {

    private int numOfLotto;
    private Lottos lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public Lottos issueLottos() {
        makeLottos();
        return this.lottos;
    }

    public void makeLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(makeLotto(new RandomNumGenerator(LottoConst.FIRST_NUM, LottoConst.LAST_NUM)));
        }
        this.lottos = new Lottos(lottos);
    }

    public Lotto makeLotto(RandomNumGenerator generator) {
        List<Integer> lotto = new ArrayList<>(generator.generate(LottoConst.LOTTO_SIZE));
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public List<Rank> findWinningResults() {
        List<Rank> results = new ArrayList<>();
        List<Integer> matchingCounts = lottos.compareAll(winningLotto);
        for (int order = 0; order < matchingCounts.size(); order++) {
            Rank result = makeRank(matchingCounts.get(order));
            result = decideSecondOrThirdPlace(order, result);
            leaveOnlyWinners(results, result);
        }
        return results;
    }

    private static void leaveOnlyWinners(List<Rank> results, Rank result) {
        if (result != null) {
            results.add(result);
        }
    }

    private static Rank makeRank(int matchingCount) {
        return Rank.getRank(matchingCount);
    }

    private Rank decideSecondOrThirdPlace(int i, Rank result) {
        if (result == Rank.SECOND && !lottos.checkLottoContainsBonusNum(i, bonusNumber)) {
            result = Rank.THIRD;
        }
        return result;
    }

    public void setNumOfLotto(int numOfPurchase) {
        this.numOfLotto = numOfPurchase;
    }


    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningLotto = new Lotto(winningNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
