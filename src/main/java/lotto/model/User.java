package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {
    private final Map<Lotto, LottoResult> lottos;
    private final Money spendMoney;

    public User(Money money) {
        this.spendMoney = money;
        this.lottos = buyLottos(spendMoney.getPurchaseLottoCount())
                .stream().collect(Collectors.toMap(lotto -> lotto, result -> LottoResult.DEFAULT));
    }

    private List<Lotto> buyLottos(int lottoCount) {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoGenerator.generate())
                .toList();
    }

    public void calculateLottoResults(WinningLotto winningLotto) {
        lottos.forEach((lotto, result) -> {
            LottoResult lottoResult = lotto.calculateResult(winningLotto);
            lottos.put(lotto, lottoResult);
        });
    }

    public List<Lotto> getLottos() {
        return lottos.keySet().stream().toList();
    }

    public List<LottoResult> getLottoResults() {
        List<LottoResult> returnResults = LottoResult.getLottoResultWithoutDefault();
        returnResults.forEach(retRes -> {
            int count = (int) lottos.values().stream().filter(userRes -> userRes == retRes).count();
            retRes.addCount(count);
        });

        return returnResults;
    }

    public double calculateStatistics() {
        double earnedMoney = sumEarnedMoney();
        return calculateRateOfReturn(earnedMoney, spendMoney.getMoney());
    }

    private double sumEarnedMoney() {
        return lottos.values().stream()
                .filter(LottoResult::isNotDefault)
                .mapToDouble(LottoResult::getPrize)
                .sum();
    }

    private double calculateRateOfReturn(double earned, double spend) {
        return earned * 100 / spend;
    }
}
