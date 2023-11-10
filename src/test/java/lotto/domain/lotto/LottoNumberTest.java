package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.config.GameConfig.MAXIMUM_LOTTO_NUMBER;
import static lotto.config.GameConfig.MINIMUM_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_RANGE_INVALID;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoNumber")
class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("범위 내의 숫자로 LottoNumber을 생성하였을 때 예외를 반환하지 않는다.")
    @ValueSource(ints = {1, 2, 4, 45, 36})
    void create_success(int randomNumber) {
        // given
        Integer number = randomNumber;

        // when, then
        assertThatCode(() -> {
            LottoNumber.create(number);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("범위 밖의 숫자로 LottoNumber을 생성하였을 때 예외를 반환한다.")
    @ValueSource(ints = {0, -1, 46, 100, -30})
    void create_fail(int randomNumber) {
        // given
        Integer number = randomNumber;

        // when, then
        assertThatThrownBy(() -> LottoNumber.create(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(
                        LOTTO_NUMBER_RANGE_INVALID.getMessage(),
                        MINIMUM_LOTTO_NUMBER.getNumber(),
                        MAXIMUM_LOTTO_NUMBER.getNumber())
                );
    }

}