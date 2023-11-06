package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Referee {
    private final Map<Prize, Integer> result;

    public Referee() {
        this.result = init();
    }

    public void judge(final List<Lotto> lottos, final WinningLotto winningLotto) {
        lottos.stream()
                .map(lotto -> compare(lotto.getNumbers(), winningLotto))
                .forEach(prize -> result.put(prize, result.getOrDefault(prize, 0) + 1));
    }

    public long getTotalPrize() {
        return result.entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    public double getRateOfReturn(final int purchaseCount) {
        final long totalPrize = getTotalPrize();
        return (double) totalPrize / purchaseCount * 100;
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner("\n");
        result.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(Prize._NONE))
                .sorted(Comparator.comparingLong(o -> o.getKey().getMoney()))
                .forEach(
                        entry -> output.add(entry.getKey() + " - " + entry.getValue() + "개"));
        return "\n당첨 통계\n---\n" + output;
    }

    private Map<Prize, Integer> init() {
        final Map<Prize, Integer> result = new HashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> result.put(prize, 0));
        return result;
    }

    private int countSameNumbers(final List<Integer> lottoNumbers, final List<Integer> winningLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    private boolean judgeContainBonusNumber(final List<Integer> lottoNumbers, final int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private Prize compare(final List<Integer> lottoNumbers, final WinningLotto winningLotto) {
        final int count = countSameNumbers(lottoNumbers, winningLotto.getNumbers());
        final boolean isBonus = judgeContainBonusNumber(lottoNumbers, winningLotto.getBonusNumber());
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.judge(count, isBonus))
                .findFirst()
                .orElse(Prize._NONE);
    }
}