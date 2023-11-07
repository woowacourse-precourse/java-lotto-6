package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class LottoCalculator {

    private static final int PERCENT_FACTOR = 100;

    public Map<WinningGrade, Integer> getMatchStatics(
            Lottos lottos,
            WinningLotto winningLotto
    ) {
        Map<WinningGrade, Integer> statics = new EnumMap<>(WinningGrade.class);

        Arrays.stream(WinningGrade.values())
                .forEach(type -> statics.put(type, 0));

        lottos.getLottos().forEach(lotto -> {
            WinningGrade winningGrade = winningLotto.matchLotto(lotto);

            int count = statics.get(winningGrade);

            statics.put(winningGrade, count + 1);
        });

        return statics;
    }

    public int getLottosProfit(Map<WinningGrade, Integer> statics) {
        return statics.entrySet().stream()
                .mapToInt(this::getProfit)
                .sum();
    }

    public float getProfitRate(int profit, int price) {
        return ((float) profit / price) * PERCENT_FACTOR;
    }

    private int getProfit(Entry<WinningGrade, Integer> entry) {
        return entry.getKey().getWinningPrice() * entry.getValue();
    }

}
