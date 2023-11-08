package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 46})
    @DisplayName("로또 번호는 1 ~ 45 사이 값이 아닌 경우 예외 발생")
    void lottoNumberBoundExceptionTest(final int number) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.valueOf(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45})
    @DisplayName("로또 번호는 1 ~ 45 사이 값인 경우 정상 생성")
    void lottoNumberTEst(final int number) {
        // expected
        assertDoesNotThrow(() -> LottoNumber.valueOf(number));
    }
}