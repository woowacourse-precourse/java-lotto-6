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

    private List<Lotto> buyLottos;

    public LottoBuyResponse buyLottos(Money money) {
        int count = money.getDividedThousandWonCount();

        buyLottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(createInRangeNumber(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)))
                .collect(Collectors.toList());

        return LottoBuyResponse.fromLottoNumbers(buyLottos);
    }

    public LottoGameResultResponse calculateResult(Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> gameResultCounts = new HashMap<>();

        for (int i = 0; i < buyLottos.size(); i++) {
            int countingMatchingNumbers = buyLottos.get(i).getCountingMatchingNumbers(winningLotto);
            ;
            boolean bonus = winningLotto.containsNumber(bonusNumber);

            LottoRank rank = LottoRank.getRankByMatchedNumbers(countingMatchingNumbers, bonus);
            gameResultCounts.put(rank, gameResultCounts.getOrDefault(rank, 0) + 1);
        }

        return LottoGameResultResponse.from(gameResultCounts);
    }
}
