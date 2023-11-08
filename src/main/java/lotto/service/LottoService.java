package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.Rank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.grobal.LottoConstants.LOTTO_PRICE;

public class LottoService {

    private final RandomLottoGenerator lottoGenerator;

    public LottoService(RandomLottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLotto(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> sortLottoNumbers(new Lotto(lottoGenerator.generate())))
                .collect(Collectors.toList());
    }

    private Lotto sortLottoNumbers(Lotto lotto) {
        List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(sortedNumbers);
        return new Lotto(sortedNumbers);
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

    public double calculateProfit(List<Lotto> purchasedLottos, Map<Rank, Long> results) {
        long purchaseAmount = purchasedLottos.size() * LOTTO_PRICE;
        long totalPrize = calculateTotalPrize(results);
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    private long calculateTotalPrize(Map<Rank, Long> results) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Long> entry : results.entrySet()) {
            totalPrize += entry.getValue() * entry.getKey().getPrizeMoney();
        }
        return totalPrize;
    }
}
