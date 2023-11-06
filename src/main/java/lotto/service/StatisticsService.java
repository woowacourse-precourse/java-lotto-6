package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.WinningLotto;
import lotto.repository.PrizeMoneyRepository;
import lotto.utils.Constants;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class StatisticsService {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREASING_VALUE = 1;
    private static final int HUNDRED = 100;

    private final PrizeMoneyRepository prizeMoneyRepository;

    public StatisticsService(PrizeMoneyRepository prizeMoneyRepository) {
        this.prizeMoneyRepository = prizeMoneyRepository;
    }

    public Map<LottoRanking, Integer> checkLottoResult(WinningLotto winningLotto, List<Lotto> userLottos) {
        Map<LottoRanking, Integer> result = new EnumMap<>(LottoRanking.class);

        for (Lotto userLotto : userLottos) {
            LottoRanking ranking = winningLotto.compare(userLotto);
            result.put(ranking, result.getOrDefault(ranking, INITIAL_COUNT) + INCREASING_VALUE);
        }

        return result;
    }

    public double calculateRateOfReturn(Map<LottoRanking, Integer> result, List<Lotto> userLottos) {
        double totalPrizeMoney = calculateTotalPrizeMoney(result);
        int totalPurchaseAmount = calculateTotalPurchaseAmount(userLottos);

        return totalPrizeMoney / totalPurchaseAmount * HUNDRED;
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

    private int calculateTotalPurchaseAmount(List<Lotto> userLottos) {
        return userLottos.size() * Constants.LOTTO_PRICE;
    }
}
