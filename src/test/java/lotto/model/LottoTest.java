package lotto.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    static Stream<Arguments> provideAnswerLotto() {
        return Stream.of(
            Arguments.of(new Lotto(List.of(1, 7, 8, 9, 10, 11)), 1),
            Arguments.of(new Lotto(List.of(1, 2, 8, 9, 10, 11)), 2),
            Arguments.of(new Lotto(List.of(40, 7, 8, 9, 10, 11)), 3)
        );
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1부터 45가 아니라면 예외가 발생힌다.")
    @Test
    void createLottoByOverRange() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Lotto(List.of(1, 2, 3, 4, 5, 50)));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto 숫자를 오름차순으로 정렬하여 반환한다.")
    @Test
    void sortNumbers() {
        assertThat(new Lotto(List.of(6, 5, 4, 3, 2, 1)).getNumbers())
            .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 숫자가 {1} 라면 0 을 반환한다.")
    @ParameterizedTest
    @MethodSource("provideAnswerLotto")
    void checkScore(Lotto inputAnswer) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.calculateScore(inputAnswer))
            .isEqualTo(0);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있으면 true 를 반환한다.")
    @Test
    void lottoHasBonus() {
        Assertions.assertTrue(new Lotto(List.of(1, 2, 3, 4, 5, 6)).hasBonus(5));
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있으면 false 를 반환한다.")
    @Test
    void lottoHasNotBonus() {
        Assertions.assertFalse(new Lotto(List.of(1, 2, 3, 4, 5, 6)).hasBonus(7));
    }
}