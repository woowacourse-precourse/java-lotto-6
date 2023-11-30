package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.WinningResult.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("당첨 로또 개수와 보너스 로또 당첨 여부에 따라 NOTHING 반환")
    @Test
    void valueOf1() {
        assertThat(valueOf(0, true)).isEqualTo(NOTHING);
    }

    @DisplayName("당첨 로또 개수와 보너스 로또 당첨 여부에 따라 FIRST 반환")
    @Test
    void valueOf2() {
        assertThat(valueOf(6, false)).isEqualTo(FIRST);
    }

    @DisplayName("당첨 로또 개수와 보너스 로또 당첨 여부에 따라 SECOND 반환")
    @Test
    void valueOf3() {
        assertThat(valueOf(5, true)).isEqualTo(SECOND);
    }
}
