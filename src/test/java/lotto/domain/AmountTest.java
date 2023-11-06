package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    @ParameterizedTest
    @DisplayName("구입금액이 최소 금액보다 모자라다면 예외 발생")
    @ValueSource(ints = {500})
    void buyAmountIsNotEnough(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구입금액이 음수일 경우 예외 발생")
    @ValueSource(ints = {-1})
    void buyAmountNegativeNumber(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구입금액이 나누어 떨어지지 않을 경우 예외 발생")
    @ValueSource(ints = {1050})
    void buyAmountDivide(int amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "구매금액 : {0}, 결과 : {1}")
    @DisplayName("구입금액에 따른 발행 로또 갯수 테스트")
    @MethodSource("lottoCount")
    void calculateLottoCount(int amount, int result) {
        assertThat(new Amount(amount).buyCount()).isEqualTo(result);
    }


    static Stream<Arguments> lottoCount() {
        return Stream.of(
                Arguments.arguments(2000, 2),
                Arguments.arguments(3000, 3),
                Arguments.arguments(4000, 4),
                Arguments.arguments(5000, 5)
        );
    }
}
