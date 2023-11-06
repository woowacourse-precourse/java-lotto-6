package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    public Map<WinningType, Integer> getMatchStatics(
            List<Lotto> lottos,
            Lotto winningLotto,
            BonusNumber bonusNumber
    ) {
        Map<WinningType, Integer> statics = new EnumMap<>(WinningType.class);

        lottos.forEach(lotto -> {
            int matchingCount = lotto.getMatchingCount(winningLotto);
            boolean matchedBonusNumber = lotto.getMatchingBonusNumber(bonusNumber.getNumber());

            WinningType winningType = WinningType.getWinningType(matchingCount, matchedBonusNumber);

            int count = statics.getOrDefault(winningType, 0);

            statics.put(winningType, count + 1);
        });

        return statics;
    }

}
