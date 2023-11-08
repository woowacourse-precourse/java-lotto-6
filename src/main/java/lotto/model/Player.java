package lotto.model;

import java.util.List;
import lotto.util.RandomUtil;

public class Player {
    private final Lottos lottos;
    private final PaymentAmount paymentAmount;
    private final RandomUtil randomUtil;

    public Player(int paymentAmount, RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
        this.paymentAmount = new PaymentAmount(paymentAmount);
        lottos = new Lottos(paymentAmount, randomUtil);
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
