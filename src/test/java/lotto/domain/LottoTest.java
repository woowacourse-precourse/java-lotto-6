package lotto.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호는 1에서 45사이의 중복되지 않는 6개의 숫자를 가진다.")
    void createLotto() {
        assertThat(lotto).extracting("numbers", InstanceOfAssertFactories.list(Integer.class))
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 총 6개의 번호로 이루어져야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호들 중 중복된 숫자가 존재합니다.");
    }

    @DisplayName("로또 번호의 숫자들 중 1보다 작거나 45보다 큰 숫자가 있다면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidNumbers")
    void createLottoByInvalidNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    static Stream<List<Integer>> invalidNumbers() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @DisplayName("사용자의 로또와 비교하여 일치하는 번호가 총 몇개인지 알 수 있다.")
    @ParameterizedTest
    @MethodSource("userLottoAndNumberOfMatches")
    void countNumberOfMatches(Lotto userLotto, int expected) {
        int actual = lotto.countNumberOfMatches(userLotto);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> userLottoAndNumberOfMatches() {
        return Stream.of(
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                arguments(new Lotto(List.of(1, 2, 3, 4, 5, 16)), 5),
                arguments(new Lotto(List.of(1, 2, 3, 4, 15, 16)), 4),
                arguments(new Lotto(List.of(1, 2, 3, 14, 15, 16)), 3)
        );
    }

    @DisplayName("보너스 번호를 포함하는지 알 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"6, true", "7, false"})
    void hasBonusNumber(int bonusNumber, boolean expected) {
        boolean actual = lotto.hasBonusNumber(new BonusNumber(bonusNumber));

        assertThat(actual).isEqualTo(expected);
    }
}