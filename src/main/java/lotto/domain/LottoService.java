package lotto.domain;

import static lotto.view.OutputView.LOTTO_SIZE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.WinnerPrice;

public class LottoService {
    public static final int FIVE = 5; // 숫자 5개가 같을때만 보너스를 비교하는 상수

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
        if (equalCount == FIVE) { // 5개의 숫자가 같을때
            if (lottoNumbers.contains(bonusNumber)) { // 보너스 숫자가 존재한다면
                equalCount += 2;
            }
        }
        return equalCount;
    }

    public double getRate(Map<Integer, Integer> result, User user) {
        int rate = 0;
        WinnerPrice[] winnerPrices = WinnerPrice.values(); //WinnerPrice Enum 을 순회한다.
        for (int i = 0; i < winnerPrices.length; i++) {
            WinnerPrice winnerPrice = winnerPrices[i];
            int index = winnerPrice.getEqualCount();
            if (result.containsKey(index)) { // WinnerPrice Enum 의 EqualCount 와 비교한다.
                rate += winnerPrice.getPriceAmount() * result.get(index);
            }
        }
        long purchaseAmount = user.getPurchaseAmount();
        double totalRate = getTotalRate(rate, purchaseAmount);
        return totalRate;
    }

    private double getTotalRate(int rate, long purchaseAmount) {
        double totalProfitRate = ((double) rate / purchaseAmount) * 100.0; // (총수익/구매금액) * 100 = 수익률이된다.
        return totalProfitRate;
    }
}
