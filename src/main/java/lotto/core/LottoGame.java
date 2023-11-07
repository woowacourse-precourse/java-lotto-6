package lotto.core;

import lotto.util.LottoConst;
import lotto.util.RandomNumGenerator;
import lotto.util.Rank;

import java.util.*;

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
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LottoConst.LOTTO_SIZE; i++) {
            lotto.add(drawNumber(generator, lotto));
        }
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public static int drawNumber(RandomNumGenerator generator, List<Integer> lotto) {
        int num;
        do {
            num = generator.generate();
        } while (lotto.contains(num));
        return num;
    }

    public List<Rank> findWinningResults() {
        List<Rank> results = new ArrayList<>();
        List<Integer> matchingCounts = lottos.compareAll(winningLotto);
        for (int i = 0; i < matchingCounts.size(); i++) {
            Rank result = makeResult(matchingCounts.get(i));
            result = decideSecondOrThirdPlace(i, result);
            leaveOnlyWinners(results, result);
        }
        return results;
    }

    private static void leaveOnlyWinners(List<Rank> results, Rank result) {
        if (result != null) {
            results.add(result);
        }
    }

    private static Rank makeResult(int matchingCount) {
        return Rank.getRank(matchingCount);
    }

    private void makeWinningResults(List<Rank> results, List<Integer> matchingCounts, int i) {

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
