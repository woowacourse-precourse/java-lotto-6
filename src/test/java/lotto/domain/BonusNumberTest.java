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

class BonusNumberTest {

    static Stream<Arguments> Parameters() {
        return Stream.of(
                Arguments.of("정답 숫자와 동일한 보너스 번호", new Lotto(List.of(1, 2, 3, 4, 5, 6)), 1),
                Arguments.of("1보다 작은 보너스 번호", new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0),
                Arguments.of("45보다 큰 보너스 번호", new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46),
                Arguments.of("음수인 보너스 번호", new Lotto(List.of(1, 2, 3, 4, 5, 6)), -1)
        );
    }

    @DisplayName("잘못된 보너스 번호인 경우 예외가 발생한다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("Parameters")
    void validateBonusNumber(String testName, Lotto answerLotto, int bonusNumbers) {
        // when, then
        assertThatThrownBy(() -> BonusNumber.of(answerLotto, bonusNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 반환한다.")
    @Test
    void getBonusNumber() {
        // given
        BonusNumber bonusNumber = BonusNumber.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        // when
        int getBonusNumber = bonusNumber.getBonusNumber();

        // then
        assertThat(getBonusNumber).isEqualTo(7);

    }

}