package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lotto.utils.GameConstants;
import lotto.utils.WinningRank;
import lotto.view.Observer;

public class LottoManager extends Observable {
    private ArrayList<Lotto> lottos;
    private WinningStatistics statistics;
    private RankEvaluator rankEvaluator;


    public LottoManager() {
        lottos = new ArrayList<>();
    }

    public void issueLottos(int purchaseAmount) {
        statistics = new WinningStatistics(purchaseAmount);

        int lottoCount = purchaseAmount / GameConstants.UNIT_PURCHASE_PRICE;

        while (lottoCount != 0) {
            List<Integer> numbers = getLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            notifyObserver(lotto);
            lottoCount--;
        }
    }

    private List<Integer> getLottoNumbers() {
        return pickUniqueNumbersInRange(GameConstants.MIN_LOTTO_NUMBER, GameConstants.MAX_LOTTO_NUMBER,
                GameConstants.LOTTO_NUMBER_COUNT);
    }

    public void setPrizeNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        PrizeNumbers prizeNumbers = new PrizeNumbers(winningNumbers, bonusNumber);
        rankEvaluator = new RankEvaluator(prizeNumbers);
    }

    public void calculateStatistics() {
        for (Lotto lotto : lottos) {
            Iterator<Integer> lottoNumbers = lotto.getIterator();
            WinningRank rank = rankEvaluator.getRank(lottoNumbers);
            statistics.updateStatistics(rank);
        }
        statistics.calculateProfitRate();

        notifyObserver(statistics);
    }

    @Override
    public void unsubscribe(Observer observer) {
    }

    @Override
    public void notifyObserver(Object data) {
        observer.update(data);
    }
}
