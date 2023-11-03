package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

    @Nested
    @DisplayName("[Price] 입력 테스트")
    class PriceSuccessTest {

        @DisplayName("로또 구입 금액 입력이 정상적인 경우를 확인")
        @ParameterizedTest
        @ValueSource(ints = {1000, 2000, 6000})
        void create_로또_구입_금액_입력이_정상적인_경우를_확인(int amount) {
            assertThatNoException().isThrownBy(()
                    -> Price.of(amount));
        }
    }

    @Nested
    @DisplayName("[Price] 예외 테스트")
    class PriceExceptionTest {

        @DisplayName("로또 구입 금액 입력이 올바르지 않은 경우를 확인")
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 1001, 9999})
        void exception_로또_구입_금액_입력이_올바르지_않은_경우를_확인(int amount) {
            assertThatThrownBy(() -> Price.of(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("[Price] 기능 테스트")
    class PriceUnitTest {

        @DisplayName("구입한 로또의 수 확인")
        @ParameterizedTest
        @CsvSource({"1000, 1", "2000, 2", "6000, 6"})
        void count_구입한_로또의_수_확인(int amount, int count) {
            Price price = Price.of(amount);

            assertThat(price.receiveIssuedLottoCount())
                    .isEqualTo(count);
        }
    }
}