package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lotto.utils.GameConstants;
import lotto.utils.WinningRank;

public class LottoManager {
    private ArrayList<Lotto> lottos;
    private WinningStatistics statistics;
    RankEvaluator rankEvaluator;


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

    public Iterator<Lotto> getLottoListIterator() {
        return lottos.iterator();
    }

    public String calculateStatistics() {
        for (Lotto lotto : lottos) {
            Iterator<Integer> lottoNumbers = lotto.getIterator();
            WinningRank rank = rankEvaluator.getRank(lottoNumbers);
            statistics.updateStatistics(rank);
        }
        statistics.calculateProfitRate();

        return statistics.toString();
    }

}
