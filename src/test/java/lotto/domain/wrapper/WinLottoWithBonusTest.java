package lotto.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.handler.ErrorHandler.INCONVERTIBLE_TYPE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinLottoWithBonusTest {

    private static Stream<Arguments> generateIncovertibleNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 10, 20, 30, 40, 45), "일"),
                Arguments.of(List.of(1, 3, 5, 6, 10, 11), "@"),
                Arguments.of(List.of(1, 3, 5, 6, 25, 36), " ")
        );
    }

    @DisplayName("보너스 번호에 숫자로 변환될 수 없는 타입이 들어가면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {1} " )
    @MethodSource("generateIncovertibleNumber")
    void createWinLottoWithBonusByInconvertibleType(List<Integer> winningLotto, String bonusNumber) {
        assertThatThrownBy(() -> WinLottoWithBonus.create(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INCONVERTIBLE_TYPE.getException().getMessage());
    }
}
