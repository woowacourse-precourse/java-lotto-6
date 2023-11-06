package lotto.model.prize;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 타입 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PrizeTypeTest {
    @Test
    @Order(1)
    @DisplayName("당첨되지 않은 경우")
    void noMatch() {
        assertThat(PrizeType.valueOf(0, false)).isEqualTo(PrizeType.NO_MATCH);
        assertThat(PrizeType.valueOf(1, false)).isEqualTo(PrizeType.ONE_MATCH);
        assertThat(PrizeType.valueOf(2, false)).isEqualTo(PrizeType.TWO_MATCH);
    }

    @Test
    @Order(2)
    @DisplayName("3개 일치")
    void threeMatch() {
        assertThat(PrizeType.valueOf(3, false)).isEqualTo(PrizeType.THREE_MATCH);
    }

    @Test
    @Order(3)
    @DisplayName("4개 일치")
    void fourMatch() {
        assertThat(PrizeType.valueOf(4, false)).isEqualTo(PrizeType.FOUR_MATCH);
    }

    @Test
    @Order(4)
    @DisplayName("5개 일치")
    void fiveMatch() {
        assertThat(PrizeType.valueOf(5, false)).isEqualTo(PrizeType.FIVE_MATCH);
    }

    @Test
    @Order(5)
    @DisplayName("5개 일치, 보너스 볼 일치")
    void fiveMatchWithBonus() {
        assertThat(PrizeType.valueOf(5, true)).isEqualTo(PrizeType.FIVE_MATCH_WITH_BONUS);
    }

    @Test
    @Order(6)
    @DisplayName("6개 일치")
    void sixMatch() {
        assertThat(PrizeType.valueOf(6, false)).isEqualTo(PrizeType.SIX_MATCH);
    }
}