package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @DisplayName("등수에 맞는 상금이 추가 계산된 금액을 반환")
    @Test
    void getCalculatedPrizeMoney() {
        Prize prize = Prize.FIRST;
        int before = 5000;
        int after = 2000005000;

        assertThat(prize.calculate(before)).isEqualTo(after);
    }
    @DisplayName("등수를 반환")
    @Test
    void getRank() {
        Prize prize = Prize.FIRST;
        int expected = 1;

        assertThat(prize.getRank()).isEqualTo(expected);
    }
    @DisplayName("당첨 번호와 일치하는 숫자 갯수를 반환")
    @Test
    void getMatchedNumber() {
        Prize prize = Prize.FIRST;
        int expected = 6;

        assertThat(prize.getMatched()).isEqualTo(expected);
    }

}