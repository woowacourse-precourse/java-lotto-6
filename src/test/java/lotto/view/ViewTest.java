package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ViewTest {

    @DisplayName("로또 등수 출력 테스트")
    @Test
    void 등수_테스트() {
        List<Rank> rankList = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD);
        UserView.winStatisticsMessage(rankList);
    }
}
