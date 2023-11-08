package lotto.Domain;

import static lotto.Util.LottoOption.LOTTO_MAX_DIGIT;
import static lotto.Util.LottoOption.LOTTO_MAX_NUMBER;
import static lotto.Util.LottoOption.LOTTO_MIN_NUMBER;
import static lotto.Util.LottoOption.LOTTO_TICKET_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Util.WinningStatistics;

public class LottoStore {
    public List<Lotto> generateLotto(int lottoPurchaseAmount) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseAmount / LOTTO_TICKET_PRICE; i++) {
            lotto.add(new Lotto(generateSortedRandomNumber()));
        }
        return lotto;
    }

    List<Integer> generateSortedRandomNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
                LOTTO_MAX_DIGIT);
        List<Integer> sortedRandomNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortedRandomNumbers);
        return sortedRandomNumbers;
    }

    public double caculateTotalLottoReward(Map<String, Integer> lottoWinningStatistics) {
        double totalReward = 0;
        for (WinningStatistics winningInformation : WinningStatistics.values()) {
            if (isExistingWinningType(lottoWinningStatistics, winningInformation)) {
                totalReward += winningInformation.calculateReward(lottoWinningStatistics);
            }
        }
        return totalReward;
    }

    private boolean isExistingWinningType(Map<String, Integer> lottoWinningStatistics,
                                          WinningStatistics winningInformation) {
        String winningType = winningInformation.getWinningType();
        return lottoWinningStatistics.get(winningType) != null;
    }
}
