package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GradeTest {

    @Test
    void draw() {
        assertThat(Grade.get(6, false)).isEqualTo(Grade.FIRST);
        assertThat(Grade.get(5, true)).isEqualTo(Grade.SECOND);
        assertThat(Grade.get(5, false)).isEqualTo(Grade.THIRD);
        assertThat(Grade.get(4, false)).isEqualTo(Grade.FOURTH);
        assertThat(Grade.get(3, false)).isEqualTo(Grade.FIFTH);
    }
}