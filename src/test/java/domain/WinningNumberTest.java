package domain;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest {

    @ParameterizedTest
    @MethodSource("provideValidWinningNumbersData")
    @DisplayName("유효한 당첨 번호와 보너스 번호로 WinningNumbers 생성")
    void createWinningNumbers(Lotto lotto, int bonusNumber) {
        assertThatCode(() -> new WinningNumbers(lotto, bonusNumber)).doesNotThrowAnyException();
        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(bonusNumber).isEqualTo(bonusNumber);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidWinningNumbersData")
    @DisplayName("보너스 번호가 당첨 번호 목록에 포함된 경우 예외 발생")
    void duplicateBonusNumberTest(Lotto lotto, int bonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    private static Stream<Arguments> provideValidWinningNumbersData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), 17)
        );
    }

    private static Stream<Arguments> provideInvalidWinningNumbersData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), 11)
        );
    }
}
