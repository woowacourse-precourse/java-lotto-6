package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Lotto> lottos;
    private final Money spendMoney;

    public User(Money money) {
        lottos = new ArrayList<>();
        this.spendMoney = money;
        buyLottos();
    }


    public List<LottoResult> getLottoResults(WinningLotto winningLotto) {
        calculateLottoResults(winningLotto);
        return lottos.stream().map(Lotto::getResult).toList();
    }

    public double getStatistics() {
        return calculateStatistic();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void buyLottos() {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        int purchaseLottoCount = spendMoney.getPurchaseLottoCount();
        for (int i = 0; i < purchaseLottoCount; i++) {
            lottos.add(lottoGenerator.generate());
        }
    }

    private void calculateLottoResults(WinningLotto winningLotto){
        lottos.forEach(lotto -> lotto.calculateResult(winningLotto));
    }

    private double calculateStatistic() {
        double earnedMoney = lottos.stream()
                .filter(lotto -> lotto.getResult() != null)
                .mapToDouble(lotto -> lotto.getResult().getPrize())
                .sum();

        return calculateRateOfReturn(earnedMoney, spendMoney.getMoney());
    }

    private double calculateRateOfReturn(double earned, double spend) {
        return earned * 100 / spend;
    }
}
