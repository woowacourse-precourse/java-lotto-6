package lotto.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.handler.ErrorHandler.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinLottoWithBonusTest {

    private static Stream<Arguments> generateIncovertibleNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 10, 20, 30, 40, 45), "일"),
                Arguments.of(List.of(1, 3, 5, 6, 10, 11), "@"),
                Arguments.of(List.of(1, 3, 5, 6, 25, 36), " ")
        );
    }

    private static Stream<Arguments> generateDuplicateNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 10, 20, 30, 40, 45), "1"),
                Arguments.of(List.of(1, 3, 5, 6, 10, 11), "10"),
                Arguments.of(List.of(1, 3, 5, 6, 25, 36), "25")
        );
    }

    private static Stream<Arguments> generateInvalidRangeNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 10, 20, 30, 40, 45), "56"),
                Arguments.of(List.of(1, 3, 5, 6, 10, 11), "-1"),
                Arguments.of(List.of(1, 3, 5, 6, 25, 36), "0")
        );
    }

    private static Stream<Arguments> generateBonusNumber() {
        return Stream.of(
                Arguments.of(WinLottoWithBonus.create(List.of(1, 10, 20, 30, 40, 45), "7"), 7),
                Arguments.of(WinLottoWithBonus.create(List.of(1, 3, 5, 6, 10, 11), "20"), 20),
                Arguments.of(WinLottoWithBonus.create(List.of(1, 3, 5, 6, 25, 36), "9"), 9)
        );
    }

    private static Stream<Arguments> generateWinningLotto() {
        return Stream.of(
                Arguments.of(WinLottoWithBonus.create(List.of(1, 10, 20, 30, 40, 45), "7"), List.of(1, 10, 20, 30, 40, 45)),
                Arguments.of(WinLottoWithBonus.create(List.of(1, 3, 5, 6, 10, 11), "20"), List.of(1, 3, 5, 6, 10, 11)),
                Arguments.of(WinLottoWithBonus.create(List.of(1, 3, 5, 6, 25, 36), "9"), List.of(1, 3, 5, 6, 25, 36))
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

    @DisplayName("보너스 번호가 당첨 번호와 중복이라면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} {1} " )
    @MethodSource("generateDuplicateNumber")
    void createWinLottoWithBonusByDuplicate(List<Integer> winningLotto, String bonusNumber) {
        assertThatThrownBy(() -> WinLottoWithBonus.create(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER.getException().getMessage());
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이의 범위가 아니라면 예외가 발생한다")
    @ParameterizedTest(name = "[{index}] input {0} {1} " )
    @MethodSource("generateInvalidRangeNumber")
    void createWinLottoWithBonusByInvalidRange(List<Integer> winningLotto, String bonusNumber) {
        assertThatThrownBy(() -> WinLottoWithBonus.create(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getException().getMessage());
    }

    @DisplayName("보너스 번호가 정상적으로 반환된다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @MethodSource("generateBonusNumber")
    void createBonusNumber(WinLottoWithBonus winLottoWithBonus, int bonusNumber) {
        assertThat(winLottoWithBonus.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("당첨 번호가 정상적으로 반환된다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @MethodSource("generateWinningLotto")
    void createWinningLotto(WinLottoWithBonus winLottoWithBonus, List<Integer> winningLotto) {
        assertThat(winLottoWithBonus.getWinningLotto()).isEqualTo(winningLotto);
    }
}
