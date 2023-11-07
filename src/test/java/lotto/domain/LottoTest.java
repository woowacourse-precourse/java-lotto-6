package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("로또 번호의 개수는 6개이다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 안된다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1 ~ 45 범위의 숫자이다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void createLottoByWrongRange(int value) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, value)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_RANGE.getMessage());
    }

    @DisplayName("보너스 번호도 기존 번호와 중복되면 안된다.")
    @Test
    void validateBonusNumberByDuplicatedNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 5;

        // when then
        assertThatThrownBy(() -> lotto.validateBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호도 범위 밖에 있으면 안된다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void validateBonusNumberByRange(int value) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when then
        assertThatThrownBy(() -> lotto.validateBonusNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_RANGE.getMessage());
    }

    @DisplayName("다른 로또와 중복 숫자를 카운트 할 수 있다.")
    @ParameterizedTest
    @MethodSource("inputLottoProvider")
    void countSameNumber(List<Integer> input, int answer) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answerLotto = new Lotto(input);

        // when
        int count = lotto.countSameNumber(answerLotto);

        // then
        assertThat(count).isEqualTo(answer);
    }

    static Stream<Arguments> inputLottoProvider() {
        return Stream.of(
                arguments(List.of(7, 8, 9, 10, 11, 12), 0),
                arguments(List.of(1, 7, 8, 9, 10, 11), 1),
                arguments(List.of(1, 2, 7, 8, 9, 10), 2),
                arguments(List.of(1, 2, 3, 7, 8, 9), 3),
                arguments(List.of(1, 2, 3, 4, 7, 8), 4),
                arguments(List.of(1, 2, 3, 4, 5, 7), 5),
                arguments(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }

    @DisplayName("보너스 번호를 포함하고 있으면 true를 반환한다.")
    @Test
    void containsTrue() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        // when
        boolean isContain = lotto.contains(bonusNumber);

        // then
        assertThat(isContain).isTrue();
    }

    @DisplayName("보너스 번호를 포함하고 있지 않으면 false를 반환한다.")
    @Test
    void containsFalse() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        boolean isContain = lotto.contains(bonusNumber);

        // then
        assertThat(isContain).isFalse();
    }

    @DisplayName("로또 번호를 리스트 문자 형태로 변활 할 수 있다.")
    @Test
    void lottoToString() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        String string = lotto.toString();

        // then
        assertThat(string).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}