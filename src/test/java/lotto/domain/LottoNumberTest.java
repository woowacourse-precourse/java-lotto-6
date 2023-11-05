package lotto.domain;

import static common.ErrorCode.LOTTO_NUMBER_INVALID_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 검증")
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또_번호_1미만_45초과_예외(int number) {
        // when
        // then
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_INVALID_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또_번호_생성(int number) {
        // when
        LottoNumber result = new LottoNumber(number);

        // then
        assertThat(result).isNotNull();
    }
}
