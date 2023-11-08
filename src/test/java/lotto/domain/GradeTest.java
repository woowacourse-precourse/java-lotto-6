package lotto.domain;

import static lotto.domain.Grade.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GradeTest {
    @DisplayName("정답, 보너스 개수에 따른 Grade를 얻을 수 있다.")
    @Test
    void fromTest() {
        assertAll(
                () -> assertThat(from(0, 0)).isEqualTo(NONE),
                () -> assertThat(from(3, 0)).isEqualTo(THREE),
                () -> assertThat(from(4, 0)).isEqualTo(FOUR),
                () -> assertThat(from(5, 0)).isEqualTo(FIVE),
                () -> assertThat(from(5, 1)).isEqualTo(FIVE_AND_BONUS),
                () -> assertThat(from(6, 0)).isEqualTo(SIX)
        );
    }
}