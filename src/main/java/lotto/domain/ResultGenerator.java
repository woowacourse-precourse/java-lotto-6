package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.constants.LottoConstraint;
import lotto.domain.constants.LottoReward;
import lotto.domain.message.OutPutMessage;


public class ResultGenerator {
    private static final List<String> WINNING_COUNT_FORMATS = List.of(
            "3개 일치 (5,000원) - %d개\n",
            "4개 일치 (50,000원) - %d개\n",
            "5개 일치 (1,500,000원) - %d개\n",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            "6개 일치 (2,000,000,000원) - %d개\n"
    );
    private final WinningLotto winningLotto;
    private final Lottos lottoTickets;
    private final Map<LottoReward, Integer> results;
    public ResultGenerator(WinningLotto winningLotto, Lottos lottoTickets) {
        this.winningLotto = winningLotto;
        this.lottoTickets = lottoTickets;
        List<LottoReward> rewards = lottoTickets.createCompareResults(winningLotto);
        results = rewards.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }

    public String generate() {
        return getWinningCountResult()+ "\n" + getProfitRatioResult();
    }

    private String getWinningCountResult(){
        List<Integer> result = getSortedRewardCounts();
        return IntStream.range(0, result.size())
                .mapToObj(i -> String.format(WINNING_COUNT_FORMATS.get(i), result.get(i)))
                .collect(Collectors.joining());
    }

    private String getProfitRatioResult(){
        return String.format(OutPutMessage.WINNING_STATISTICS.getValue(), calculateProfitRatio(calculatePrizeMoney()));
    }

    public List<Integer> getSortedRewardCounts() {
        return Arrays.stream(LottoReward.values())
                .filter(LottoReward::isNotFail)
                .map(condition -> results.getOrDefault(condition, 0))
                .toList();
    }

    private long calculatePrizeMoney() {
        return results.entrySet().stream()
                .mapToLong(result -> result.getValue() * result.getKey().getRewardMoney())
                .sum();
    }

    private double calculateProfitRatio(final long totalPrizeMoney) {
        return totalPrizeMoney / (double) (lottoTickets.getSize() * LottoConstraint.LOTTO_PRICE.getValue()) * 100;
    }
}
