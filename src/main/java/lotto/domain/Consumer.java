package lotto.domain;

import lotto.type.Prize;
import lotto.view.OutputView;

import java.io.PipedReader;
import java.util.List;

public class Consumer {
    private List<Lotto> purchasedLotto;

    private List<Prize> prizeResult;

    private Consumer(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public static Consumer purchaseLotto(List<Lotto> purchasedLotto) {
        return new Consumer(purchasedLotto);
    }

    public double getReturnRate() {
        if(prizeResult == null || purchasedLotto.size() < 1) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for(Prize prize : prizeResult) {
            sum += prize.getPrize();
        }
        return sum / (purchasedLotto.size() * 1000);
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public void setPurchasedLotto(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Prize> getPrizeResult() {
        return prizeResult;
    }

    public void setPrizeResult(List<Prize> prizeResult) {
        this.prizeResult = prizeResult;
    }
}
