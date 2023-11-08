package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.PrizeCategory;

public class MessageContainer {
    private static final String UNIT = "개";

    public List<String> createWinningDetails(Map<PrizeCategory, Integer> map) {
        List<String> WinningDetails = new ArrayList<>();
        WinningDetails.add(PrizeCategory.FIFTH.getMessage() + map.get(PrizeCategory.FIFTH) + UNIT);
        WinningDetails.add(PrizeCategory.FOURTH.getMessage() + map.get(PrizeCategory.FOURTH) + UNIT);
        WinningDetails.add(PrizeCategory.THIRD.getMessage() + map.get(PrizeCategory.THIRD) + UNIT);
        WinningDetails.add(PrizeCategory.SECOND.getMessage() + map.get(PrizeCategory.SECOND) + UNIT);
        WinningDetails.add(PrizeCategory.FIRST.getMessage() + map.get(PrizeCategory.FIRST) + UNIT);
        return WinningDetails;
    }
}
