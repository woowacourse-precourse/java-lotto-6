package lotto.service;

import static lotto.utils.NumberGenerator.createInRangeNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.dto.LottoBuyResponse;
import lotto.dto.LottoGameResultResponse;

public class LottoGameService {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int COST_PER_LOTTO = 1000;

    private List<Lotto> buyLottos;

    public LottoBuyResponse buyLottos(Money money) {
        int count = money.getDividedThousandWonCount();

        buyLottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(createInRangeNumber(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)))
                .collect(Collectors.toList());

        return LottoBuyResponse.fromLottoNumbers(buyLottos);
    }

    public LottoGameResultResponse calculateResult(Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> gameResultCounts = getGameResultCounts(winningLotto, bonusNumber);
        double profitRate = getProfitRate(gameResultCounts);

        return LottoGameResultResponse.from(gameResultCounts, profitRate);
    }

    private double getProfitRate(Map<LottoRank, Integer> gameResultCounts) {
        int totalPrize = 0;
        for (LottoRank rank : gameResultCounts.keySet()) {
            totalPrize += rank.getPrize() * gameResultCounts.getOrDefault(rank, 0);
        }

        int totalCount = gameResultCounts.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        int totalCost = COST_PER_LOTTO * totalCount;

        return ((double) totalPrize / totalCost) * 100;
    }

    private Map<LottoRank, Integer> getGameResultCounts(Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> gameResultCounts = new HashMap<>();

        for (int i = 0; i < buyLottos.size(); i++) {
            int countingMatchingNumbers = buyLottos.get(i).getCountingMatchingNumbers(winningLotto);
            boolean bonus = winningLotto.containsNumber(bonusNumber);

            LottoRank rank = LottoRank.getRankByMatchedNumbers(countingMatchingNumbers, bonus);
            gameResultCounts.put(rank, gameResultCounts.getOrDefault(rank, 0) + 1);
        }
        return gameResultCounts;
    }
}
