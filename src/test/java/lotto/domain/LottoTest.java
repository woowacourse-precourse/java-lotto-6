package lotto.domain;

import lotto.config.ErrorMessage;
import lotto.config.WinningPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_LOTTO.message());
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("wrongLottoSize")
    void createLottoByWrongSize(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_LOTTO_SIZE.message());
    }

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("wrongLottoRange")
    void createLottoByOverRangeNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_LOTTO_RANGE.message());
    }

    @DisplayName("로또 번호와 겹치는 번호인지를 확인")
    @Test
    void checkLottoWithSingleNumber() {
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(testLotto.checkDuplicates(3)).isTrue();
    }

    @DisplayName("로또 당첨결과 확인")
    @ParameterizedTest
    @MethodSource("lottoAndResult")
    void compareLottoWithAnswer(Lotto target, WinningPrize result) {
        Lotto answerNumbers = new Lotto(List.of(17, 12, 9, 24, 36, 7));
        assertThat(target.compareWithAnswer(answerNumbers, 32)).isEqualTo(result);
    }

    static Stream<Arguments> wrongLottoSize() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5))
        );
    }

    static Stream<Arguments> wrongLottoRange() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(-1, 1, 2, 3, 4, 5))
        );
    }

    static Stream<Arguments> lottoAndResult() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(13, 11, 8, 26, 3, 2)), null), // 0개
                Arguments.of(new Lotto(List.of(13, 12, 8, 26, 3, 2)), null), // 1개
                Arguments.of(new Lotto(List.of(13, 9, 12, 26, 32, 2)), null), // 2개
                Arguments.of(new Lotto(List.of(9, 13, 12, 24, 3, 32)), WinningPrize.FIFTH_PLACE), // 3개
                Arguments.of(new Lotto(List.of(17, 12, 9, 24, 3, 32)), WinningPrize.FOURTH_PLACE), // 4개
                Arguments.of(new Lotto(List.of(36, 24, 9, 12, 17, 2)), WinningPrize.THIRD_PLACE), // 5개
                Arguments.of(new Lotto(List.of(24, 36, 12, 9, 17, 32)), WinningPrize.SECOND_PLACE), // 5개 + 보너스
                Arguments.of(new Lotto(List.of(36, 24, 9, 7, 12, 17)), WinningPrize.FIRST_PLACE) // 6개
        );
    }
}
