package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Nested
@DisplayName("로또 번호가")
public class LottoNumberTest {
    @DisplayName("1~45까지의 조건에 부합하다면")
    class input_is_correct {
        @ParameterizedTest
        @ValueSource(ints = {1, 44, 45})
        @DisplayName("통과")
        void create(final int number) {
            assertThatCode(() -> new LottoNumber(number)).doesNotThrowAnyException();
        }
    }
    @Nested
    @DisplayName("문자로 입력된다면")
    class input_is_not_int {
        @Test
        @DisplayName("에러 출력")
        void returns_error() {
            assertThatThrownBy(() -> new LottoNumber("abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("1~45까지의 숫자가 아니라면")
    class input_is_not_proper_range {
        @ParameterizedTest
        @ValueSource(ints = {-46, 0, 46})
        @DisplayName("에러 출력")
        void returns_error(final int number) {
            assertThatThrownBy(() -> new LottoNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }
}
