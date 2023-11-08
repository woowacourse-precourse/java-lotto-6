package lotto.domain;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void valueOfTest() {
        assertThat(valueOf(2, 50000)).isEqualTo("2E-50000");
        assertThat(valueOf(3, 5000)).isEqualTo("3E-5000");
        assertThat(valueOf(4, 0)).isEqualTo("4");
        assertThat(valueOf(0, 0)).isEqualTo("0");

    }

}