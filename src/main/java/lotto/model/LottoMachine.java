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

        List<List<Integer>> lottoNumbers = getLottoNumbers(lottos);

        for (Lotto lotto : lottos) {
            Prize prize = calculatePrize(lotto, winNumbers, bonusNumber);
            prizeCounts.put(prize, prizeCounts.getOrDefault(prize, 0) + 1);
        }

        return new LottoResult(winNumbers, bonusNumber, lottoNumbers, prizeCounts);
    }

    private List<List<Integer>> getLottoNumbers(List<Lotto> lottos) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }

    private Prize calculatePrize(Lotto lotto, List<Integer> winNumbers, int bonusNumber) {
        int matchCount = countMatchingNumbers(lotto, winNumbers);
        int bonusMatchCount = countBonusMatch(lotto, bonusNumber);

        if (matchCount == 6) return Prize.FIRST;
        if (matchCount == 5 && bonusMatchCount == 1) return Prize.SECOND;
        if (matchCount == 5) return Prize.THIRD;
        if (matchCount == 4) return Prize.FOURTH;
        if (matchCount == 3) return Prize.FIFTH;

        return Prize.NONE;
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
