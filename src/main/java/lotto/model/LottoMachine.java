package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {
    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoPrice = 1000;
        int numberOfLottos = purchaseAmount / lottoPrice;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            Lotto lotto = Lotto.generateRandomLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public LottoResult calculateResult(List<Lotto> lottos, List<Integer> winNumbers, int bonusNumber) {
        Map<Prize, Integer> prizeCounts = new EnumMap<>(Prize.class);
        prizeCounts.put(Prize.FIRST, 0);
        prizeCounts.put(Prize.SECOND, 0);
        prizeCounts.put(Prize.THIRD, 0);
        prizeCounts.put(Prize.FOURTH, 0);
        prizeCounts.put(Prize.FIFTH, 0);

        List<List<Integer>> convertedLottos = lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, winNumbers);
            int bonusMatchCount = countBonusMatch(lotto, bonusNumber);
            Prize prize = calculatePrize(matchCount, bonusMatchCount);

            int currentCount=prizeCounts.getOrDefault(prize,0);
            prizeCounts.put(prize, currentCount + 1);
        }

        return new LottoResult(winNumbers, bonusNumber, convertedLottos, prizeCounts);
    }

    private Prize calculatePrize(int matchCount, int bonusMatchCount) {
        Prize prize = Prize.NONE;

        if (matchCount == 6) prize = Prize.FIRST;
        if (matchCount == 5 && bonusMatchCount == 1) prize = Prize.SECOND;
        if (matchCount == 5 && bonusMatchCount == 0) prize = Prize.THIRD;
        if (matchCount == 4) prize = Prize.FOURTH;
        if (matchCount == 3) prize = Prize.FIFTH;

        return prize;
    }

    private int countMatchingNumbers(Lotto lotto, List<Integer> winNumbers) {
        return (int) winNumbers.stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    private int countBonusMatch(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }
}
