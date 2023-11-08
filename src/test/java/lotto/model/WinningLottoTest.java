package lotto.model;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @ParameterizedTest
    @MethodSource("createSuccessWinningLottoData")
    @DisplayName("Winning_Lotto_객체_생성")
    void createWinningLotto(List<Integer> inputList, int inputBonusNumber) {
        assertThat(new WinningLotto(inputList, inputBonusNumber))
                .isInstanceOf(WinningLotto.class);
    }

    private static Stream<Arguments> createSuccessWinningLottoData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 13),
                Arguments.of(List.of(13, 14, 15, 16, 17, 18), 19)
        );
    }

    @ParameterizedTest
    @MethodSource("exceedWinningLottoNumbers")
    @DisplayName("당첨_로또_번호_개수_6개_불일치_예외")
    void createLottoByOverSize(List<Integer> inputList, int inputBonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(inputList, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBERS_SIZE.getErrorMessage());
    }

    private static Stream<Arguments> exceedWinningLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7), 8),
                Arguments.of(List.of(7, 8, 9, 10, 11), 14),
                Arguments.of(List.of(13, 14, 15, 16, 17, 18, 19), 20)
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateWinningNumber")
    @DisplayName("당첨_로또_번호_중복_예외_발생")
    void createLottoByDuplicatedNumber(List<Integer> inputList, int inputBonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(inputList, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_WINNING_NUMBER.getErrorMessage());
    }

    private static Stream<Arguments> duplicateWinningNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 5), 7),
                Arguments.of(List.of(7, 8, 9, 10, 11, 45), 45),
                Arguments.of(List.of(13, 14, 15, 16, 17, 17), 17)
        );
    }

    @ParameterizedTest
    @MethodSource("notRangeWinningNumber")
    @DisplayName("잘못된_당첨_로또_번호_범위_예외")
    void createLottoByNotRangeNumber(List<Integer> inputList, int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(inputList, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBERS_RANGE.getErrorMessage());
    }

    private static Stream<Arguments> notRangeWinningNumber() {
        return Stream.of(
                Arguments.of(List.of(-1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(7, 8, 9, 10, 11, 46), 6),
                Arguments.of(List.of(0, 14, 15, 16, 17, 18), 19)
        );
    }
}
