package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberTest {
    private static Stream<Arguments> normalBonusNumberArguments() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.arguments(List.of(43, 32, 34, 25, 41, 26), 2)
        );
    }

    private static Stream<Arguments> exceptionBonusNumberArguments() {
        return Stream.of(
                Arguments.arguments("당첨 번호와 중복된 경우", List.of(1, 2, 3, 4, 5, 6), 2),
                Arguments.arguments("0인 경우", List.of(1, 2, 3, 4, 5, 6), 0),
                Arguments.arguments("음수인 경우", List.of(1, 2, 3, 4, 5, 6), -30),
                Arguments.arguments("45보다 큰 수인 경우", List.of(1, 2, 3, 4, 5, 6), 46)
        );
    }

    @ParameterizedTest(name = "보너스 번호 : {1}, 당첨 번호 : {0}")
    @MethodSource("normalBonusNumberArguments")
    @DisplayName("정상적인 보너스 숫자 테스트")
    void normalBonusNumberTest(List<Integer> winningNumbers, Integer bonusNumber) {
        // when, then
        assertDoesNotThrow(() -> new BonusNumber(winningNumbers, bonusNumber));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("exceptionBonusNumberArguments")
    @DisplayName("예외적인 보너스 숫자 테스트")
    void exceptionBonusNumberTest(String testName, List<Integer> winningNumbers, Integer bonusNumber) {
        // when, then
        assertThatThrownBy(() -> new BonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
