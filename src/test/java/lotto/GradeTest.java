package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GradeTest {

    @Test
    void draw() {
        assertThat(Grade.draw(6, false)).isEqualTo(Grade.FIRST);
        assertThat(Grade.draw(5, true)).isEqualTo(Grade.SECOND);
        assertThat(Grade.draw(5, false)).isEqualTo(Grade.THIRD);
        assertThat(Grade.draw(4, false)).isEqualTo(Grade.FOURTH);
        assertThat(Grade.draw(3, false)).isEqualTo(Grade.FIFTH);
    }
}