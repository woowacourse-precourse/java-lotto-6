package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.dto.LottoGameResponse;
import lotto.utils.NumberGenerator;

public class LottoGameService {
    private List<Lotto> buyLottos;

    public LottoGameResponse buy(Money money) {
        buyLottos = new ArrayList<>();
        int count = money.getDividedThousandWonCount();

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(NumberGenerator.createInRangeNumber(1, 45, 6));
            buyLottos.add(lotto);
        }

        return new LottoGameResponse(count, buyLottos.stream().map(Lotto::getNumbers).collect(Collectors.toList()));
    }

    public Map<LottoRank, Integer> calculateResult(String winningNumbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        Map<LottoRank, Integer> result = new HashMap<>();

        for (int i = 0; i < buyLottos.size(); i++) {
            int countingMatchingNumbers = 0;
            boolean bonus;

            countingMatchingNumbers = buyLottos.get(i).getCountingMatchingNumbers(winningLotto);
            bonus = winningLotto.containsNumber(bonusNumber);

            LottoRank rank = LottoRank.getRankByMatchedNumbers(countingMatchingNumbers, bonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }
}
