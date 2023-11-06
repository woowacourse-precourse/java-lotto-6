package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {
    private final Map<Lotto, LottoResult> lottos;
    private final Money spendMoney;

    public User(Money money) {
        this.spendMoney = money;
        this.lottos = buyLottos(spendMoney.getPurchaseLottoCount())
                .stream()
                .collect(Collectors.toMap(lotto -> lotto, result -> LottoResult.DEFAULT));
    }

    public List<LottoResult> getLottoResults(WinningLotto winningLotto) {
        calculateLottoResults(winningLotto);
        return lottos.values().stream().filter(Objects::nonNull).toList();
    }

    public double getStatistics() {
        double earnedMoney = sumEarnedMoney();
        return calculateRateOfReturn(earnedMoney, spendMoney.getMoney());
    }

    public List<Lotto> getLottos() {
        return lottos.keySet().stream().toList();
    }

    private List<Lotto> buyLottos(int lottoCount) {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoGenerator.generate())
                .toList();
    }

    private void calculateLottoResults(WinningLotto winningLotto){
        lottos.forEach((lotto, result) -> {
            LottoResult lottoResult = lotto.calculateResult(winningLotto);
            lottos.put(lotto, lottoResult);
        });
    }

    private double sumEarnedMoney() {
        return lottos.values().stream()
                .filter(Objects::nonNull)
                .mapToDouble(LottoResult::getPrize)
                .sum();
    }

    private double calculateRateOfReturn(double earned, double spend) {
        return earned * 100 / spend;
    }
}
