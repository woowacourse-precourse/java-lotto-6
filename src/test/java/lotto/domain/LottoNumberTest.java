package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.LottoNumber;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 번호 생성 불가 테스트 - 범위 벗어남")
    @ValueSource(ints = {-45, -1, 0, 46, 99})
    void createLottoNumberFailTest(int value) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(value));
    }

    @Test
    @DisplayName("로또 정상 생성")
    void createLottoNumberSuccessTest() {
        assertDoesNotThrow(() -> IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .toList());
    }
}
