package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.enums.LottoConstraint;
import lotto.domain.enums.LottoReward;
import lotto.domain.enums.Message;


public class LottoResult {
    private final Lottos lottoTickets;
    private final WinningLotto winningLotto;
    private final Map<LottoReward, Integer> results;

    private static final List<String> WINNING_COUNT_FORMATS = List.of(
            "3개 일치 (5,000원) - %d개\n",
            "4개 일치 (50,000원) - %d개\n",
            "5개 일치 (1,500,000원) - %d개\n",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            "6개 일치 (2,000,000,000원) - %d개\n"
    );
    public LottoResult(WinningLotto winningLotto, Lottos lottoTickets) {
        this.winningLotto = winningLotto;
        this.lottoTickets = lottoTickets;
        List<LottoReward> rewards = lottoTickets.createCompareResults(winningLotto);
        results = rewards.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }

    public String generate() {
        return getWinningCount()+ "\n" + getPerformance();
    }

    private String getWinningCount(){
        List<Integer> result = getSortedRewardCounts();
        return IntStream.range(0, result.size())
                .mapToObj(i -> String.format(WINNING_COUNT_FORMATS.get(i), result.get(i)))
                .collect(Collectors.joining());
    }

    private String getPerformance(){
        return String.format(Message.PERFORMANCE_MESSAGE.getValue(), calculatePerformance(calculatePrizeAmount()));
    }

    public List<Integer> getSortedRewardCounts() {
        return Arrays.stream(LottoReward.values())
                .filter(LottoReward::isNotFail)
                .map(condition -> results.getOrDefault(condition, 0))
                .toList();
    }

    private long calculatePrizeAmount() {
        return results.entrySet().stream()
                .mapToLong(result -> result.getValue() * result.getKey().getPrizeAmount())
                .sum();
    }

    private double calculatePerformance(final long totalPrizeMoney) {
        return totalPrizeMoney / (double) (lottoTickets.getSize() * LottoConstraint.LOTTO_UNIT_PRICE.getValue()) * 100;
    }
}