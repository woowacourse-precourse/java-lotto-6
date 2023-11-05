package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @DisplayName("일치하는 번호가 6개면 1등을 반환한다.")
    @Test
    void ofFirstPrize() {
        // given & when
        final Prize prize = Prize.of(6, 0);

        // then
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @DisplayName("일치하는 번호가 5개, 일치하는 보너스 번호가 1개면 2등을 반환한다.")
    @Test
    void ofSecondPrize() {
        // given & when
        final Prize prize = Prize.of(5, 1);

        // then
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @DisplayName("일치하는 번호가 5개면 3등을 반환한다.")
    @Test
    void ofThirdPrize() {
        // given & when
        final Prize prize = Prize.of(5, 0);

        // then
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @DisplayName("일치하는 번호가 4개면 4등을 반환한다.")
    @Test
    void ofFourthPrize() {
        // given & when
        final Prize prize = Prize.of(4, 0);

        // then
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @DisplayName("일치하는 번호가 3개면 5등을 반환한다.")
    @Test
    void ofFifthPrize() {
        // given & when
        final Prize prize = Prize.of(3, 0);

        // then
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("일치하는 번호가 2개이하면 NONE을 반환한다.")
    @Test
    void ofNonePrize() {
        // given & when
        final Prize prize = Prize.of(2, 0);

        // then
        assertThat(prize).isEqualTo(Prize.NONE);
    }
}
