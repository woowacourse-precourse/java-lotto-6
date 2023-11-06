package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lotto.utils.GameConstants;

public class LottoManager {
    private ArrayList<Lotto> lottos;
    private WinningStatistics statistics;
    private WinningNumbers winningNumbers;

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

    public void setWinningNumbers(Map<Integer, Integer> sequencedNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(sequencedNumbers, bonusNumber);
    }

    public Iterator<Lotto> getLottoListIterator() {
        return lottos.iterator();
    }

    public String getStatistics() {
        Iterator<Lotto> lottoIterator = lottos.iterator();
        statistics.calculateStatistics(winningNumbers, lottoIterator);
        return statistics.toString();
    }
}
