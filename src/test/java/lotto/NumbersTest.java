package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @DisplayName("로또 번호가 문자를 포함하면 예외가 발생한다.")
    @Test
    void createLottoByNotNumber() {
        assertThatThrownBy(() -> new Numbers(List.of("1", "2", "abc", "4", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
