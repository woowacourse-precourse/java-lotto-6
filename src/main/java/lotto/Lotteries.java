package lotto;

import static lotto.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.LottoConstants.LOTTO_NUMBERS;
import static lotto.LottoConstants.LOTTO_TICKET_PRICE;
import static lotto.LottoConstants.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotteries {

    private final List<Lotto> lotteries;

    public Lotteries(int purchaseAmount) {
        this.lotteries = purchaseLotteries(purchaseAmount);
    }

    private List<Lotto> purchaseLotteries(int purchaseAmount) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < (purchaseAmount / LOTTO_TICKET_PRICE); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS);
            Lotto lotto = new Lotto(numbers);
            lotteries.add(lotto);
        }
        return lotteries;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public Map<WinningRanking, Integer> getWinningStatistics(Lotto winningNumbers, int bonusNumber) {
        Map<WinningRanking, Integer> winningStatistics = initWinningStatistics();
        for (Lotto lotto : this.lotteries) {
            int countOfMatch = lotto.getMatchingCountOfWinningNumbers(winningNumbers);
            boolean matchOfBonusNumber = lotto.containsBonusNumber(bonusNumber);
            WinningRanking winningRanking = WinningRanking.getWinningRanking(countOfMatch, matchOfBonusNumber);
            if (winningRanking != null) {
                winningStatistics.put(winningRanking, winningStatistics.get(winningRanking) + 1);
            }
        }
        return winningStatistics;
    }

    private Map<WinningRanking, Integer> initWinningStatistics() {
        Map<WinningRanking, Integer> winningStatistics = new HashMap<>();
        for (WinningRanking ranking : WinningRanking.values()) {
            winningStatistics.put(ranking, ZERO);
        }
        return winningStatistics;
    }
}
