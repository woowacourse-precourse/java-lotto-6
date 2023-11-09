package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Nested
@DisplayName("입력한 구입 금액이")
public class MoneyTest {
    @Nested
    @DisplayName("입력 조건에 부합한다면")
    class input_is_correct {
        @Test
        @DisplayName("통과")
        void create() {
            assertThatCode(() -> new Money("18000")).doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("int형으로 파싱할 수 없다면(문자가 입력된다면)")
    class input_int {
        @Test
        @DisplayName("에러 출력")
        void returns_error() {
            assertThatThrownBy(() -> new Money("abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("로또 한 장도 구입할 수 없다면")
    class input_lower_than_1000 {
        @Test
        @DisplayName("에러 출력")
        void returns_error() {
            assertThatThrownBy(() -> new Money("500"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("로또 한 장의 가격으로 나누어 떨어지지 않는다면")
    class input_not_multiple_1000 {
        @Test
        @DisplayName("에러 출력")
        void returns_error() {
            assertThatThrownBy(() -> new Money("500"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }
}
