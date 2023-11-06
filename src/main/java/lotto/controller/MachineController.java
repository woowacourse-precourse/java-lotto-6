package lotto.controller;

import lotto.model.Human;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.utils.LottoCompare;
import lotto.utils.Random;
import lotto.view.OutputView;
import lotto.view.PurchaseView;
import lotto.view.WinningLottoView;

import java.util.*;

public class MachineController {
    private Human human;
    private WinningLotto winningLotto;
    private Lottos lottos;

    public void execution() {
        initAmount();
        initLottos();
        OutputView.displayPurchaseList(lottos);
        initWinningLotto();
        OutputView.displayLottoCompareResult(compare());
        OutputView.displayProfit(calcProfit());
    }

    public void initAmount() {
        int money = PurchaseView.lotto();
        human = new Human(money);
    }

    public void initWinningLotto() {
        List<Integer> lottos = WinningLottoView.publishLotto();
        int bonus = WinningLottoView.publishBonus(lottos);
        winningLotto = new WinningLotto(lottos, bonus);
    }

    public void initLottos() {
        int count = human.getCount();
        List<Lotto> tempLottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            tempLottos.add(new Lotto(Random.generate()));
        }
        lottos = new Lottos(tempLottos);
    }

    public float calcProfit() {
        float winningAmount = 0;
        for(int prize : calcPrize()) {
            winningAmount += prize;
        }
        return (winningAmount / human.getMoney()) * 100;
    }

    public List<Integer> calcPrize() {
        List<LottoCompare> lottoCompares = compare();
        return List.of(
                Collections.frequency(lottoCompares, LottoCompare.FIFTH) * LottoCompare.FIFTH.getPrize(),
                Collections.frequency(lottoCompares, LottoCompare.FOURTH) * LottoCompare.FOURTH.getPrize(),
                Collections.frequency(lottoCompares, LottoCompare.THIRD) * LottoCompare.THIRD.getPrize(),
                Collections.frequency(lottoCompares, LottoCompare.SECOND) * LottoCompare.SECOND.getPrize(),
                Collections.frequency(lottoCompares, LottoCompare.FIRST) * LottoCompare.FIRST.getPrize()
        );
    }

    public List<LottoCompare> compare() {
        List<LottoCompare> lottoCompareResults = new ArrayList<>();

        for(int i = 0; i < human.getCount(); i++) {
            int match = compareLotto(lottos.getLottos().get(i));
            boolean isIncludeBonusNumbers = compareBonus(lottos.getLottos().get(i));
            LottoCompare lottoResult = LottoCompare.getCompareResult(match, isIncludeBonusNumbers);
            lottoCompareResults.add(lottoResult);
        }

        return lottoCompareResults;
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
