package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Constants;

class WinningLottoTest {

    private final Lotto lotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {0, 46})
    @DisplayName("당첨 번호 예외 처리: 보너스 번호가 범위를 벗어난 경우")
    void givenLottoAndBonusNumber_whenCreateWinningLotto_thenThrowException(int bonusNumber) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("로또 번호는 1 ~ 45 숫자만 가능합니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    @DisplayName("당첨 번호 예외 처리: 당첨 번호 중 하나와 중복된 경우")
    void givenLottoAndBonusNumber_whenCreateWinningLotto_thenThrowDuplicationException(int bonusNumber) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("당첨 번호에 이미 존재하는 숫자입니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = {1, 45})
    @DisplayName("당첨 번호 생성 성공")
    void givenLottoAndBonusNumber_whenCreateWinningLotto_thenNoException(int bonusNumber) {
        // when & then
        assertThatNoException()
                .isThrownBy(() -> new WinningLotto(lotto, bonusNumber));
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @MethodSource("provideDataForCountMatchingNumber")
    @DisplayName("사용자가 구매한 로또와 당첨 번호를 비교: 일치하는 당첨 번호 수를 알려준다")
    void givenWinningLottoAndUserLotto_whenCountMatchingNumber_thenReturnCount(List<Integer> numbers, int expected) {
        // given
        WinningLotto winningLotto = new WinningLotto(lotto, 1);
        Lotto userLotto = new Lotto(numbers);

        // when
        int result = winningLotto.countMatchingNumber(userLotto);

        // then
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideDataForCountMatchingNumber() {
        return Stream.of(
                Arguments.of(List.of(2, 10, 11, 12, 13, 14), 1),
                Arguments.of(List.of(2, 3, 11, 12, 13, 14), 2),
                Arguments.of(List.of(2, 3, 4, 12, 13, 14), 3),
                Arguments.of(List.of(2, 3, 4, 5, 13, 14), 4),
                Arguments.of(List.of(2, 3, 4, 5, 6, 14), 5),
                Arguments.of(List.of(2, 3, 4, 5, 6, 7), 6)
        );
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @MethodSource("provideDataForHasBonusNumber")
    @DisplayName("사용자가 구매한 로또와 당첨 번호를 비교: 보너스 번호를 맞췄는지 알려준다")
    void givenWinningLottoAndUserLotto_whenHasBonusNumber_thenReturnResult(List<Integer> numbers, boolean expected) {
        // given
        WinningLotto winningLotto = new WinningLotto(lotto, 1);
        Lotto userLotto = new Lotto(numbers);

        // when
        boolean result = winningLotto.hasBonusNumber(userLotto);

        // then
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideDataForHasBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), true),
                Arguments.of(List.of(2, 3, 4, 5, 6, 7), false)
        );
    }

}
