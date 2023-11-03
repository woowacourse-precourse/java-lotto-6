package lotto.domain;

import lotto.type.Prize;
import lotto.view.OutputView;

import java.util.List;

public class Consumer {
    private List<Lotto> purchasedLotto;

    public Consumer(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public double getReturnRate(List<Prize> result) {
        int sum = 0;
        for(Prize prize : result) {
            sum += prize.getPrize();
        }
        return (double) sum / (purchasedLotto.size() * 1000);
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }


}
