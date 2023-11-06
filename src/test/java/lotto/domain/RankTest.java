package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("조건에 맞는 RANK를 생성함")
    @Test
    void createRankTest() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.from(2, true));
        ranks.add(Rank.from(3, true));
        ranks.add(Rank.from(4, true));
        ranks.add(Rank.from(5, false));
        ranks.add(Rank.from(5, true));
        ranks.add(Rank.from(6, true));

        int index = 0;

        for (Rank rank : Rank.values()) {
            assertEquals(rank, ranks.get(index));
            index++;
        }
    }

}
