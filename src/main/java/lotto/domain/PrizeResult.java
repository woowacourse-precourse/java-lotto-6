package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeResult {
    private static final String RESULT_FORMAT = "%s - %d개";

    EnumMap<Prize, Integer> prizeCounts;

    private PrizeResult() {
        this.prizeCounts = new EnumMap<>(Prize.class);

        Arrays.stream(Prize.values())
                    .forEach(prize -> prizeCounts.put(prize, 0));
    }

    public static PrizeResult of(Lottos lottos, WinningLotto winningLotto) {
        PrizeResult prizeResult = new PrizeResult();

        lottos.getLottos().forEach(lotto -> {
            Prize prize = prizeResult.calculatePrize(lotto, winningLotto);
            prizeResult.updatePrizeCount(prize);
        });

        return prizeResult;
    }

    public List<String> getResults() {
        return prizeCounts.entrySet().stream()
                .map(entry
                        -> String.format(RESULT_FORMAT, entry.getKey().getPrint(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public int getPrizeMoney() {
        return prizeCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getMoneyByCount(entry.getValue()))
                .sum();
    }

    private Prize calculatePrize(Lotto lotto, WinningLotto winningLotto) {
        return Prize.getPrizeByCount(
                lotto.calculateMatchCount(winningLotto.getWinningLotto()),
                lotto.isContain(winningLotto.getBonusNumber())
        );
    }

    private void updatePrizeCount(Prize prize) {
        if (prize != null) {
            prizeCounts.put(prize, prizeCounts.get(prize) + 1);
        }
    }
}
