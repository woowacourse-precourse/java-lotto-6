package lotto.domain;

import static lotto.view.OutputView.LOTTO_SIZE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.WinnerPrice;

public class LottoService {
    public static final int FIVE = 5;

    public Map<Integer, Integer> compareValue(List<Lotto> lottos, User user) {
        int equalCount;
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            equalCount = compareLine(lotto, user);
            if (result.get(equalCount) == null) {
                result.put(equalCount, 1);
                continue;
            }
            result.put(equalCount, result.get(equalCount) + 1);
        }
        return result;
    }

    private int compareLine(Lotto lotto, User user) {
        List<Integer> winnerNumbers = user.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        int equalCount = 0;

        for (int i = 0; i < LOTTO_SIZE; i++) {
            if (lottoNumbers.contains(winnerNumbers.get(i))) {
                equalCount++;
            }
        }
        equalCount = bonus(equalCount, lottoNumbers, user.getBonusNumber());
        return equalCount;
    }

    private int bonus(int equalCount, List<Integer> lottoNumbers, long bonusNumber) {
        if (equalCount == FIVE) {
            if (lottoNumbers.contains(bonusNumber)) {
                equalCount += 2;
            }
        }
        return equalCount;
    }

    public double getRate(Map<Integer, Integer> result, User user) {
        int rate = 0;
        WinnerPrice[] winnerPrices = WinnerPrice.values();
        for (int i = 0; i < winnerPrices.length; i++) {
            WinnerPrice winnerPrice = winnerPrices[i];
            int index = winnerPrice.getEqualCount();
            if (result.containsKey(index)) {
                rate += winnerPrice.getPriceAmount() * result.get(index);
            }
        }
        long purchaseAmount = user.getPurchaseAmount();
        double totalRate = getTotalRate(rate, purchaseAmount);
        return totalRate;
    }

    private double getTotalRate(int rate, long purchaseAmount) {
        double totalProfitRate = ((double) rate / purchaseAmount) * 100.0;
        return totalProfitRate;
    }
}
