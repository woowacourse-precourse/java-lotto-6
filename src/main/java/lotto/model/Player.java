package lotto.model;

import java.util.List;
import lotto.util.RandomUtil;

public class Player {
    private final Lottos lottos;
    private final PaymentAmount paymentAmount;

    public Player(int paymentAmount) {
        lottos = new Lottos(paymentAmount, new RandomUtil());
        this.paymentAmount = new PaymentAmount(paymentAmount);
    }

    public double calculateProfitRate(WinningNumbers winningNumbers) {
        WinningDetail winningDetail = new WinningDetail(lottos.getLottos(), winningNumbers);
        long totalProfit = winningDetail.totalProfit();
        return (Double.valueOf(totalProfit) / paymentAmount.getPrice()) * 100;
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
