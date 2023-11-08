package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Winnings.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningsTest {

    @Test
    void winningsValue() {
        assertThat(FIRST_PLACE.getWinningsNumber()).isEqualTo(2000000000);
        assertThat(SECOND_PLACE.getWinningsNumber()).isEqualTo(30000000);
        assertThat(THIRD_PLACE.getWinningsNumber()).isEqualTo(1500000);
        assertThat(FOURTH_PLACE.getWinningsNumber()).isEqualTo(50000);
        assertThat(FIFTH_PLACE.getWinningsNumber()).isEqualTo(5000);
    }

    @Test
    void getWinnings() {
        Winnings winnings = Winnings.check(3, 0);
        assertThat(winnings).isEqualTo(FIFTH_PLACE);
    }

    @Test
    void getNoneWinnings() {
        Winnings winnings = Winnings.check(1, 1);
        assertThat(winnings).isEqualTo(NONE);
    }
}
