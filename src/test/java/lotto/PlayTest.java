package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayTest {
    private Play play;

    @BeforeEach
    void setPlay() {
        play = new Play();
    }

    @DisplayName("1000원 단위가 아니면 예외 발생.")
    @Test
    void 천원_단위_테스트() {
        assertThatThrownBy(() -> play.validate("10100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아니면 예외 발생.")
    @Test
    void 숫자가_맞는지() {
        assertThatThrownBy(() -> play.validate("1000ㄹ"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
