package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import lotto.utils.Constants;

public class Referee {
    private final Map<Prize, Integer> result;

    public Referee() {
        this.result = init();
    }

    public void judge(final List<Lotto> lottos, final WinningLotto winningLotto) {
        lottos.stream()
                .map(lotto -> compare(lotto.getNumbers(), winningLotto))
                .forEach(prize -> result.put(prize, result.getOrDefault(prize, Constants.INIT_VALUE) + Constants.INCREMENT_VALUE));
    }

    public long getTotalPrize() {
        return result.entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    public double getRateOfReturn(final int purchaseCount) {
        final long totalPrize = getTotalPrize();
        return (double) totalPrize / purchaseCount * Constants.PERCENT_VALUE;
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(Constants.ENTER_LINE);
        result.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(Prize.NONE))
                .sorted(Comparator.comparingLong(prize -> prize.getKey().getMoney()))
                .forEach(entry -> output.add(entry.getKey() + Constants.HYPHEN + entry.getValue() + Constants.COUNT));
        return Constants.PRIZE_MESSAGE + output;
    }

    private Map<Prize, Integer> init() {
        final Map<Prize, Integer> result = new HashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> result.put(prize, Constants.INIT_VALUE));
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
                .orElse(Prize.NONE);
    }
}