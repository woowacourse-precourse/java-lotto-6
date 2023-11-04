package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또를 이루는 번호 테스트")
class LottoNumberTest {

    @DisplayName("1-45의 범위를 지키는 수는 검증을 통과한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    void testInRangeLottoNumberValidation(int number) {
        assertThatNoException().isThrownBy(() -> LottoNumber.from(number));
    }

    @DisplayName("1-45의 범위를 지키지 않는 수는 검증에 실패한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void testOutOfRangeLottoNumberValidation(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number));
    }
}