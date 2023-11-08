package lotto.Domain;

import static lotto.Util.InputValidator.checkDivisibleBy1000;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Customer {
    private List<Lotto> purchasedLottos;
    private int lottoPurchaseAmount;

    public List<Lotto> buyLotto(LottoStore lottoStore, String lottoPurchaseAmount) {
        checkDivisibleBy1000(lottoPurchaseAmount);
        this.lottoPurchaseAmount = Integer.parseInt(lottoPurchaseAmount);
        this.purchasedLottos = lottoStore.generateLotto(this.lottoPurchaseAmount);
        return this.purchasedLottos;
    }

    public List<String> getPurchasedLottoNumbers() {
        List<String> purchasedLottoNumbers = new ArrayList<>();
        for (Lotto lotto : this.purchasedLottos) {
            purchasedLottoNumbers.add(lotto.getLottoNumbers());
        }
        return purchasedLottoNumbers;
    }

    public double calculateRateOfReturn(double totalReward) {
        double rateOfReturn = totalReward / (double) this.lottoPurchaseAmount * 100;
        return Math.round(rateOfReturn * 10.0) / 10.0;
    }
}
