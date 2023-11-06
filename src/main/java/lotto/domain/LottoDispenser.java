package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDispenser {

    public static Lottos issueLottos(Money money) {
        long lottoIssueCount = money.calculatePurchasableLottosCount();

        List<List<Integer>> randomNumbers = LottoNumberGenerator.generateRandomNumbers(
            lottoIssueCount);

        return new Lottos(mapToLottos(randomNumbers));
    }

    private static List<Lotto> mapToLottos(List<List<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
            .map(Lotto::new)
            .collect(Collectors.toList());
    }
}
