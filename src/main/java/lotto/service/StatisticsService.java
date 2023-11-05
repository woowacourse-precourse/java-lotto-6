package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.repository.PrizeMoneyRepository;
import lotto.utils.Constants;

import java.util.List;
import java.util.Map;

public class StatisticsService {
    private static final int HUNDRED = 100;
    private static final int INITIAL_VALUE = 0;

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

        return totalPrizeMoney / totalPurchaseAmount * HUNDRED;
    }

    private int calculateTotalPurchaseAmount(Map<LottoRanking, Integer> result) {
        return result.values()
                .stream()
                .map(value -> value * Constants.LOTTO_PRICE)
                .reduce(INITIAL_VALUE, Integer::sum);
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
