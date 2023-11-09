package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    static Stream<Arguments> countParameters() {
        return Stream.of(
                Arguments.of("5개 일치할 경우", new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 6, 7)), 5),
                Arguments.of("4개 일치할 경우", new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(3, 4, 5, 6, 7, 8)), 4),
                Arguments.of("3개 일치할 경우", new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(4, 5, 6, 7, 8, 9)), 3),
                Arguments.of("2개 일치할 경우", new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(5, 6, 7, 8, 9, 10)), 2),
                Arguments.of("1개 일치할 경우", new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(6, 7, 8, 9, 10, 11)), 1)
        );
    }

    static Stream<Arguments> bonusParameters() {
        return Stream.of(
                Arguments.of("보너스 번호를 포함할 경우", new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6, true),
                Arguments.of("보너스 번호를 포함하지 않을 경우", new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7, false)
        );
    }

    @DisplayName("정답 번호와 구입한 로또 번호의 동일한 숫자 개수를 반환한다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("countParameters")
    void countCorrectLottoNumbers(String testName, Lotto answerLotto, Lotto userLotto, int expectedCount) {
        // when
        int correctCount = userLotto.countCorrectLottoNumbers(answerLotto);

        // then
        assertThat(correctCount).isEqualTo(expectedCount);
    }


    @DisplayName("구입한 로또가 보너스 번호를 가지고 있는지 확인한다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("bonusParameters")
    void containsBonusNumber(String testName, Lotto lotto, int bonusNumber, boolean result) {
        assertThat(lotto.containsBonusNumber(bonusNumber)).isEqualTo(result);
    }

    @DisplayName("로또 번호를 Integer List 를 문자열로 반환한다.")
    @Test
    void numbersToString() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}