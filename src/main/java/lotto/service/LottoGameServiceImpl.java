package lotto.service;

import static lotto.utils.LottoNumberGenerator.createInRangeNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchaseCost;
import lotto.dto.request.LottoNumberRequest;
import lotto.dto.request.LottoPurchaseCostRequest;
import lotto.dto.request.LottoRequest;
import lotto.dto.response.LottoBuyResponse;
import lotto.dto.response.LottoGameResultResponse;

public class LottoGameServiceImpl implements LottoGameService {
    public static final int COST_PER_LOTTO = 1000;

    private List<Lotto> buyLottos;

    public LottoGameServiceImpl() {
    }

    public LottoGameServiceImpl(List<Lotto> buyLottos) {
        this.buyLottos = buyLottos;
    }

    public LottoBuyResponse buyLottos(LottoPurchaseCostRequest lottoPurchaseCostRequest) {
        LottoPurchaseCost lottoPurchaseCost = new LottoPurchaseCost(
                Integer.parseInt(lottoPurchaseCostRequest.getLottoPurchaseCost()));
        int count = lottoPurchaseCost.getDividedThousandWonCount();

        buyLottos = IntStream.range(0, count)
                .mapToObj(i -> Lotto.createLotto(createInRangeNumber()))
                .collect(Collectors.toList());

        return LottoBuyResponse.fromLottoNumbers(buyLottos);
    }

    public LottoGameResultResponse calculateResult(LottoRequest winningLotto, LottoNumberRequest bonusLottoNumber) {
        Map<LottoRank, Integer> gameResultCounts = getGameResultCounts(Lotto.createLotto(winningLotto.getLotto()),
                new LottoNumber(bonusLottoNumber.getLottoNumber()));
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

    private Map<LottoRank, Integer> getGameResultCounts(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        Map<LottoRank, Integer> gameResultCounts = new HashMap<>();

        for (int i = 0; i < buyLottos.size(); i++) {
            int countingMatchingNumbers = buyLottos.get(i).getCountingMatchingNumbers(winningLotto);
            boolean bonus = winningLotto.containsNumber(bonusLottoNumber);

            LottoRank rank = LottoRank.getRankByMatchedNumbers(countingMatchingNumbers, bonus);
            gameResultCounts.put(rank, gameResultCounts.getOrDefault(rank, 0) + 1);
        }
        return gameResultCounts;
    }
}
