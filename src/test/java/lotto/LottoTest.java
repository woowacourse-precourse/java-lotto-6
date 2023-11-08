package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.bonus.BonusNumber;
import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("로또 번호에 1 ~ 45에 속하지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByWrongRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 46, 1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"1,2,a,4,5,6", "1,2, ,4,5,6", "1,2,!,4,5,6"})
    @ParameterizedTest
    void createWinningLottoByNotNumber(String numbers) {
        assertThatThrownBy(() -> new WinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또를 비교하여 맞는 개수를 구한다.")
    @Test
    void getMatchNumberCount() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Integer result = winningLotto.getMatchNumberCount(lotto);

        assertThat(result).isEqualTo(5);
    }

    @DisplayName("로또에 일치하는 보너스 번호가 있는지 확인")
    @MethodSource("getBonusNumberTestArguments")
    @ParameterizedTest
    void hasBonusNumber(List<Integer> number, BonusNumber bonus, boolean answer) {
        Lotto lotto = new Lotto(number);

        boolean result = lotto.hasBonusNumber(bonus);

        assertThat(result).isEqualTo(answer);
    }

    private static Stream<Arguments> getBonusNumberTestArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6),
                        BonusNumber.of("6", new WinningLotto("1,2,3,4,5,7")), true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6),
                        BonusNumber.of("7", new WinningLotto("1,2,3,4,5,6")), false)
        );
    }
}
