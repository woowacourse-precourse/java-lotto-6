package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private final RandomLottoGenerator lottoGenerator;

    public LottoService(RandomLottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLotto(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(lottoGenerator.generate()))
                .collect(Collectors.toList());
    }

    public Map<Rank, Long> calculateResults(Lotto winningLotto, List<Lotto> purchasedLottos, int bonusNumber) {
        Map<Rank, Long> results = new HashMap<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            Rank rank = getRank(winningLotto, purchasedLotto, bonusNumber);
            if (rank != Rank.NO_LUCK) {
                results.put(rank, results.getOrDefault(rank, 0L) + 1);
            }
        }
        return results;
    }

    private Rank getRank(Lotto winningLotto, Lotto purchasedLotto, int bonusNumber) {
        boolean isBonusMatched = purchasedLotto.getNumbers().contains(bonusNumber);
        int matchCount = countMatchingNumbers(winningLotto, purchasedLotto);
        return Rank.checkWinningStatus(matchCount, isBonusMatched);
    }

    private int countMatchingNumbers(Lotto winningLotto, Lotto purchasedLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return (int) purchasedLotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
