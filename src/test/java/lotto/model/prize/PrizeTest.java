package lotto.model.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("당첨 결과 테스트")
class PrizeTest {
    @Test
    @DisplayName("객체 생성 테스트")
    void createPrize() {
        Prize prize = new Prize(1000, 1, 2, 3, 4, 5);
        assertThat(prize.prizeMoney()).isEqualTo(1000);
        assertThat(prize.threeMatchCount()).isEqualTo(1);
        assertThat(prize.fourMatchCount()).isEqualTo(2);
        assertThat(prize.fiveMatchCount()).isEqualTo(3);
        assertThat(prize.fiveMatchWithBonusCount()).isEqualTo(4);
        assertThat(prize.sixMatchCount()).isEqualTo(5);
    }
}