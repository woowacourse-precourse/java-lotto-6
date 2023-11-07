package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.model.Lottos;

public class LottoCalculator {

    private static final int PERCENT_FACTOR = 100;

    public Map<WinningType, Integer> getMatchStatics(
            Lottos lottos,
            Lotto winningLotto,
            BonusNumber bonusNumber
    ) {
        Map<WinningType, Integer> statics = new EnumMap<>(WinningType.class);

        Arrays.stream(WinningType.values())
                .forEach(type -> statics.put(type, 0));

        lottos.getLottos().forEach(lotto -> {
            int matchingCount = lotto.getMatchingCount(winningLotto);
            boolean matchedBonusNumber = lotto.getMatchingBonusNumber(bonusNumber.getNumber());

            WinningType winningType = WinningType.getWinningType(matchingCount, matchedBonusNumber);

            int count = statics.get(winningType);

            statics.put(winningType, count + 1);
        });

        return statics;
    }

    public int getLottosProfit(Map<WinningType, Integer> statics) {
        return statics.entrySet().stream()
                .mapToInt(this::getProfit)
                .sum();
    }

    public float getProfitRate(int profit, int price) {
        return ((float) profit / price) * PERCENT_FACTOR;
    }

    private int getProfit(Entry<WinningType, Integer> entry) {
        return entry.getKey().getWinningPrice() * entry.getValue();
    }

}
