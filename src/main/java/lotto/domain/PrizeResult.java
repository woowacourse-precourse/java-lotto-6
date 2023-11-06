package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeResult {
    private static final String RESULT_FORMAT = "%s - %d개";

    EnumMap<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);

    public PrizeResult(Lottos lottos, WinningLotto winningLotto) {
        Arrays.stream(Prize.values()).forEach(prize -> prizeCount.put(prize, 0));

        lottos.getLottos().forEach(lotto ->
                updatePrizeCount(calculatePrize(lotto, winningLotto))
        );
    }

    public EnumMap<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    public List<String> getResults() {
        return prizeCount.entrySet().stream()
                .map(entry
                        -> String.format(RESULT_FORMAT, entry.getKey().getPrint(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public int getPrizeMoney() {
        int prizeMoney = 0;
        for (EnumMap.Entry<Prize, Integer> entry : prizeCount.entrySet()) {
            prizeMoney += (entry.getKey().getMoney() * entry.getValue());
        }
        return prizeMoney;
    }

    private Prize calculatePrize(Lotto lotto, WinningLotto winningLotto) {
        return Prize.getPrizeByCount(
                lotto.calculateMatchCount(winningLotto.getWinningLotto()),
                lotto.isContain(winningLotto.getBonusNumber())
        );
    }

    private void updatePrizeCount(Prize prize) {
        if (prize != null) {
            prizeCount.put(prize, prizeCount.get(prize) + 1);
        }
    }
}
