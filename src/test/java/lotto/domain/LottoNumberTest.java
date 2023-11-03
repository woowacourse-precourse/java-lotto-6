package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 번호 생성 불가 테스트 - 범위 벗어남")
    @ValueSource(ints = {-45, -1, 0, 46, 99})
    void createLottoNumberFailTest(int value) {
        assertThrows(IllegalArgumentException.class, new LottoNumber(value));
    }
}
