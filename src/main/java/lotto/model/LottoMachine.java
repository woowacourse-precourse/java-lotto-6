package lotto.model;

import lotto.utils.LottoCompare;

import java.util.*;

public class LottoMachine {
    private final Lottos lottos;
    private final WinningLotto winningLotto;
    private final List<LottoCompare> lottoCompares;

    public LottoMachine(Lottos lottos, WinningLotto winningLotto, int count) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.lottoCompares = initCompares(count);
    }

    private List<LottoCompare> initCompares(int count) {
        List<LottoCompare> lottoCompareResults = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            int match = compareLotto(lottos.getLottos().get(i));
            boolean isIncludeBonusNumbers = compareBonus(lottos.getLottos().get(i));
            LottoCompare lottoResult = LottoCompare.getCompareResult(match, isIncludeBonusNumbers);
            lottoCompareResults.add(lottoResult);
        }

        return lottoCompareResults;
    }

    public List<LottoCompare> getLottoCompares() {
        return Collections.unmodifiableList(lottoCompares);
    }

    public float calcProfit(int money) {
        float winningAmount = calcPrize();
        return (winningAmount / money) * 100;
    }

    public int calcPrize() {
        int firstPrize = Collections.frequency(lottoCompares, LottoCompare.FIRST) * LottoCompare.FIRST.getPrize();
        int secondPrize = Collections.frequency(lottoCompares, LottoCompare.SECOND) * LottoCompare.SECOND.getPrize();
        int thirdPrize = Collections.frequency(lottoCompares, LottoCompare.THIRD) * LottoCompare.THIRD.getPrize();
        int fourthPrize = Collections.frequency(lottoCompares, LottoCompare.FOURTH) * LottoCompare.FOURTH.getPrize();
        int fifthPrize = Collections.frequency(lottoCompares, LottoCompare.FIFTH) * LottoCompare.FIFTH.getPrize();
        return firstPrize + secondPrize + thirdPrize + fourthPrize + fifthPrize;
    }

    public int compareLotto(Lotto lotto) {
        Set<Integer> tempLotto = new HashSet<>(lotto.getNumbers());
        Set<Integer> tempWinningLotto = new HashSet<>(winningLotto.getLotto());

        tempLotto.retainAll(tempWinningLotto);
        return tempLotto.size();
    }

    public boolean compareBonus(Lotto lotto) {
        return lotto.getNumbers().contains(winningLotto.getBonus());
    }
}
