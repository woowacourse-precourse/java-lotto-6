package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.repository.PrizeMoneyRepository;

import java.util.List;
import java.util.Map;

public class StatisticsService {
    private final PrizeMoneyRepository prizeMoneyRepository;

    public StatisticsService(PrizeMoneyRepository prizeMoneyRepository) {
        this.prizeMoneyRepository = prizeMoneyRepository;
    }

    public LottoResult checkLottoResult(WinningLotto winningLotto, List<Lotto> userLottos) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto userLotto : userLottos) {
            LottoRanking ranking = winningLotto.compare(userLotto);
            lottoResult.record(ranking);
        }

        return lottoResult;
    }

    public double calculateRateOfReturn(LottoResult lottoResult) {
        Map<LottoRanking, Integer> result = lottoResult.getResult();

        double totalPrizeMoney = calculateTotalPrizeMoney(result);
        int totalPurchaseAmount = calculateTotalPurchaseAmount(result);

        return totalPrizeMoney / totalPurchaseAmount * 100;
    }

    private int calculateTotalPurchaseAmount(Map<LottoRanking, Integer> result) {
        return result.values()
                .stream()
                .map(value -> value * 1000)
                .reduce(0, Integer::sum);
    }

    private double calculateTotalPrizeMoney(Map<LottoRanking, Integer> result) {
        return result.keySet()
                .stream()
                .mapToDouble(lottoRanking -> calculatePrizeMoney(result, lottoRanking))
                .sum();
    }

    private int calculatePrizeMoney(Map<LottoRanking, Integer> result, LottoRanking lottoRanking) {
        return result.get(lottoRanking) * prizeMoneyRepository.findByLottoRanking(lottoRanking);
    }
}
