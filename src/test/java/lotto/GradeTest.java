package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GradeTest {


    @Test
    void get() {
        assertThat(Grade.get(6, false)).isEqualTo(Optional.of((Grade.FIRST)));
        assertThat(Grade.get(6, true)).isEqualTo(Optional.empty());

        assertThat(Grade.get(5, true)).isEqualTo(Optional.of(Grade.SECOND));

        assertThat(Grade.get(5, false)).isEqualTo(Optional.of(Grade.THIRD));

        assertThat(Grade.get(4, false)).isEqualTo(Optional.of(Grade.FOURTH));
        assertThat(Grade.get(4, true)).isEqualTo(Optional.of(Grade.FOURTH));

        assertThat(Grade.get(3, true)).isEqualTo(Optional.of(Grade.FIFTH));
        assertThat(Grade.get(3, false)).isEqualTo(Optional.of(Grade.FIFTH));
    }
}