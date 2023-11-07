package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @DisplayName("(복권 개수가 1 미만 or 중복된 숫자 or 중복된 보너스 숫자 or 범위를 벗어난 숫자)이면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0,6,7", "1,5,7", "1,6,6", "1,46,7"})
    public void testConstructor(int size, int wrongNumber, int bonus) {
        assertThatThrownBy(() -> new Game(size, List.of(1, 2, 3, 4, 5, wrongNumber), bonus))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
}
