package lotto.model;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import org.junit.jupiter.api.Test;


import static lotto.model.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {
    @DisplayName("6개의 숫자를 맞춰서 FIRST가 나오는지 확인한다.")
    @Test
    void correctFirstOfPrize() {
        Lotto playerInputNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Prize prize = new Prize(lotto, 7);
        assertThat(prize.match(playerInputNumber)).isEqualTo(FIRST);
    }


}
