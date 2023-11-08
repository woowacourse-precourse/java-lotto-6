package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.lotto.LottoRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    static Stream<Arguments> providePlayerLottos() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), 0),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 11)), 4),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6)
        );
    }

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

    @DisplayName("로또 번호는 1 부터 45사이의 숫자여야 한다.")
    @Test
    void createLottoWhenContainsNonNumeric() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 66)))
                .isInstanceOf(LottoRangeException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("일치 한 로또 번호의 갯수를 리턴 한다.")
    @ParameterizedTest
    @MethodSource("providePlayerLottos")
    void countMatchLottoNumber(Lotto playerLotto, int expectedCount) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int matchingCount = winningLotto.countMatchingNumbers(playerLotto);

        assertThat(matchingCount).isEqualTo(expectedCount);
    }

    @DisplayName("보너스 번호 일치 여부를 리턴 한다.")
    @Test
    void hasBonusNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        BonusNumber trueNumber = BonusNumber.of(5);
        BonusNumber falseNumber = BonusNumber.of(7);
        boolean containNumber = winningLotto.contains(trueNumber);
        boolean notContainNumber = winningLotto.contains(falseNumber);

        assertThat(containNumber).isTrue();
        assertThat(notContainNumber).isFalse();
    }
}