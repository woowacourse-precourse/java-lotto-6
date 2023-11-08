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

    @DisplayName("5개의 숫자와 보너스 숫자를 맞춰서 SECOND가 나오는지 확인한다.")
    @Test
    void correctSecondPrize() {
        Lotto playerInputNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Prize prize = new Prize(lotto, 7);
        assertThat(prize.match(playerInputNumber)).isEqualTo(SECOND);
    }

    @DisplayName("5개의 숫자를 맞춰서 THIRD가 나오는지 확인한다.")
    @Test
    void correctThirdPrize() {
        Lotto playerInputNumber = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Prize prize = new Prize(lotto, 7);
        assertThat(prize.match(playerInputNumber)).isEqualTo(THIRD);
    }

    @DisplayName("4개의 숫자와 보너스 숫자를 맞춰서 FOURTH가 나오는지 확인한다.")
    @Test
    void correctFourthPrize() {
        Lotto playerInputNumber = new Lotto(List.of(1, 2, 3, 4, 9, 8));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Prize prize = new Prize(lotto, 7);
        assertThat(prize.match(playerInputNumber)).isEqualTo(FOURTH);
    }

    @DisplayName("3개의 숫자를 맞춰서 FIFTH가 나오는지 확인한다.")
    @Test
    void correctFifthPrize() {
        Lotto playerInputNumber = new Lotto(List.of(1, 2, 3, 9, 10, 8));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Prize prize = new Prize(lotto, 7);
        assertThat(prize.match(playerInputNumber)).isEqualTo(FIFTH);
    }

}
