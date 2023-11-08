package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 번호의 범위를 벗어난 값으로 로또 번호를 생성하면 예외가 발생한다.")
    @ValueSource(ints = {-45, -1, 0, 46, 99})
    void createLottoNumberOutOfRange(int value) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(value));
    }

    @Test
    @DisplayName("로또 정상 생성")
    void createLottoNumber() {
        assertDoesNotThrow(() -> IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .toList());
    }
}
