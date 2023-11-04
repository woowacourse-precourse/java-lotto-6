package lotto.domain;

import org.mockito.junit.MockitoTestRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prizes {

    private final Map<Prize, Integer> prizes;

    public Prizes(List<Prize> prizeDummy) {
        this.prizes = new HashMap<>();
        createPrizeMap(prizeDummy);
    }

    private void createPrizeMap(List<Prize> prizeDummy) {
        for (Prize prize : prizeDummy) {
            if (prizes.containsKey(prize)) {
                prizes.put(prize, prizes.get(prize)+1);
            } else {
                prizes.put(prize, 1);
            }
        }
    }




}
