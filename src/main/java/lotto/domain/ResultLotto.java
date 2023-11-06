package lotto.domain;

import lotto.constant.LottoConfig;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultLotto {
    private final Map<Prize, Integer> result = new EnumMap<>(Prize.class);

    public ResultLotto() {
        for (Prize prize : Prize.values()) {
            result.put(prize, LottoConfig.NUMBER_ZERO);
        }
    }

    public void addResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        Prize prize = MatchLotto.calculate(lotto, winningNumbers, bonusNumber);
        result.putIfAbsent(prize, LottoConfig.NUMBER_ZERO);
        result.put(prize, result.get(prize) + LottoConfig.NUMBER_ONE);
    }

    public void printResult() {
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.EMPTY)
                .forEach(prize -> System.out.println(prize.getMessage()
                        + result.getOrDefault(prize, LottoConfig.NUMBER_ZERO) + LottoConfig.NUMBER_COUNT));
    }
}
