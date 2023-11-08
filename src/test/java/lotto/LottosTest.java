package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(8000);
    }

    @Test
    void numberLottosTest() {
        int expectedNumber = 8;
        int actualNumber = lottos.numberLottos(8000);
        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

}
