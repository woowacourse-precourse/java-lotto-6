package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lotto.utils.GameConstants;

public class LottoManager {
    private ArrayList<Lotto> lottos;
    private WinningStatistics statistics;
    private PrizeNumbers prizeNumbers;


    public LottoManager() {
        lottos = new ArrayList<>();
    }

    public void issueLottos(int purchaseAmount) {
        statistics = new WinningStatistics(purchaseAmount);

        int lottoCount = purchaseAmount / GameConstants.UNIT_PURCHASE_PRICE;

        while (lottoCount != 0) {
            List<Integer> numbers = pickUniqueNumbersInRange(GameConstants.MIN_LOTTO_NUMBER,
                    GameConstants.MAX_LOTTO_NUMBER, GameConstants.LOTTO_NUMBER_COUNT);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            lottoCount--;
        }
    }

    public void setPrizeNumbers(Set<Integer> winningNumbers, int bonusNumber) {

        this.prizeNumbers = new PrizeNumbers(winningNumbers, bonusNumber);
    }

    public Iterator<Lotto> getLottoListIterator() {
        return lottos.iterator();
    }

    public String getStatistics() {
        Iterator<Lotto> lottoIterator = lottos.iterator();
        statistics.calculateStatistics(prizeNumbers, lottoIterator);
        return statistics.toString();
    }
}
