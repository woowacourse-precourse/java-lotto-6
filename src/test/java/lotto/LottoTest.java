package lotto;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 숫자 리스트로 Lotto 생성 시 성공한다.")
    @ParameterizedTest(name = "[{index}] validNumbers: {arguments}")
    @MethodSource("validNumbersProvider")
    void givenValidNumbers_whenLottoIsCreated_thenSuccess(List<Integer> validNumbers) {
        // When
        Lotto lotto = new Lotto(validNumbers);

        // Then
        assertThat(lotto.getNumbers()).isEqualTo(validNumbers);
    }

    @DisplayName("유효하지 않은 숫자 리스트로 Lotto 생성 시 예외를 발생시킨다.")
    @ParameterizedTest(name = "[{index}] invalidNumbers: {argumentsWithNames}")
    @MethodSource("invalidNumbersProvider")
    void givenInvalidNumbers_whenCreatingLotto_thenThrowsException(List<Integer> invalidNumbers, String expectedMessage) {
        // When & Then
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private static Stream<List<Integer>> validNumbersProvider() {
        return Stream.of(
                List.of(1, 12, 23, 34, 45, 19),
                List.of(2, 13, 24, 35, 36, 20),
                List.of(3, 14, 25, 26, 37, 21)
        );
    }

    private static Stream<Arguments> invalidNumbersProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 12, 23, 34, 45), "로또는 6개의 숫자로 이루어져야 합니다."),
                Arguments.of(List.of(0, 12, 23, 34, 45, 46), "로또 숫자의 범위는 1에서 45 사이여야 합니다."),
                Arguments.of(List.of(1, 12, 12, 34, 45, 19), "중복된 숫자가 존재합니다.")
        );
    }
}
