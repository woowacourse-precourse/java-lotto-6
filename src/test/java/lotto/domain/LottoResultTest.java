package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("match 수가 0일 때 NONE을 반환하는지")
    @Test
    void returnNONEResultWhenMatchIsZero() {
        assertThat(LottoResult.of(0)).isEqualTo(LottoResult.NONE);
    }

    @DisplayName("match 수가 1일 때 NONE을 반환하는지")
    @Test
    void returnNONEResultWhenMatchIsOne() {
        assertThat(LottoResult.of(1)).isEqualTo(LottoResult.NONE);
    }

    @DisplayName("match 수가 2일 때 NONE을 반환하는지")
    @Test
    void returnNONEResultWhenMatchIsTwo() {
        assertThat(LottoResult.of(2)).isEqualTo(LottoResult.NONE);
    }

    @DisplayName("match 수가 3일 때 FIFTH을 반환하는지")
    @Test
    void returnNONEResultWhenMatchIsThree() {
        assertThat(LottoResult.of(3)).isEqualTo(LottoResult.FIFTH);
    }

    @DisplayName("match 수가 4일 때 FOURTH를 반환하는지")
    @Test
    void returnNONEResultWhenMatchIsFour() {
        assertThat(LottoResult.of(4)).isEqualTo(LottoResult.FOURTH);
    }

    @DisplayName("match 수가 5일 때 THIRD을 반환하는지")
    @Test
    void returnNONEResultWhenMatchIsFive() {
        assertThat(LottoResult.of(5)).isEqualTo(LottoResult.THIRD);
    }

    @DisplayName("match 수가 6일 때 FIRST을 반환하는지")
    @Test
    void returnNONEResultWhenMatchIsSix() {
        assertThat(LottoResult.of(6)).isEqualTo(LottoResult.FIRST);
    }
}