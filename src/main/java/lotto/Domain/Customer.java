package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Util.WinningStatistics;

public class Customer {
    private List<Lotto> purchasedLottos;

    public List<Lotto> buyLotto(LottoStore lottoStore, String lottoPurchaseAmount) {
        this.purchasedLottos = lottoStore.generateLotto(lottoPurchaseAmount);
        return this.purchasedLottos;
    }

    public List<String> getPurchasedLottoNumbers() {
        List<String> purchasedLottoNumbers = new ArrayList<>();
        for (Lotto lotto : this.purchasedLottos) {
            purchasedLottoNumbers.add(lotto.getNumbers());
        }
        return purchasedLottoNumbers;
    }

    public double calculateRateOfReturn(Map<String, Integer> lottoWinningStatistics) {
        double investMoney = purchasedLottos.size() * 1000;
        double totalReward = 0;
        for (WinningStatistics num : WinningStatistics.values()) {
            if (lottoWinningStatistics.get(Integer.toString(num.getMatchNumber())) != null) {
                totalReward += (double) lottoWinningStatistics.get(Integer.toString(num.getMatchNumber())) * num.getReward();
            }
        }
        double rateOfReturn = totalReward / investMoney * 100;
        return Math.round(rateOfReturn * 10.0) / 10.0;
    }
}
