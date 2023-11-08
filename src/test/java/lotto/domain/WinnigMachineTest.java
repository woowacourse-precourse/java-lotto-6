package lotto.domain;

import static lotto.utils.ConstantString.DELIMITER;
import static lotto.utils.ConstantValues.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantValues.MIN_LOTTO_NUMBER;
import static lotto.utils.ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.utils.ErrorMessages.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinnigMachineTest {

    @DisplayName("보너스 번호가 1~45사이가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void getBonusNumberByOverRangeOfNumber(int number) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, number)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LOTTO_NUMBER_OUT_OF_RANGE, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("당첨 번호가 보너스 번호를 이미 갖고 있다면 중복으로 취급하여 예외가 발생한다.")
    @Test
    void getBonusNumberContainedInWinningLotto() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;
        // when, then
        assertThatThrownBy(() -> new WinnigMachine(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_CONTAINS_BONUS_NUMBER);
    }

    @DisplayName("당첨 번호와 로또 번호를 비교하여 등수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:FIRST",
            "1,2,3,4,5,7:SECOND",
            "1,2,3,4,5,8:THIRD",
            "1,2,3,4,7,8:FOURTH",
            "1,2,3,7,8,9:FIFTH",
            "1,2,7,8,9,10:NO_PRIZE"
    }, delimiter = ':')
    void getPrize(String inputNumbers, Prize expectedPrize) {
        // given
        List<Integer> numbers = Arrays.stream(inputNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
        Lotto playerLotto = new Lotto(numbers);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinnigMachine winnigMachine = new WinnigMachine(winningLotto, bonusNumber);
        // when
        Prize prize = winnigMachine.getPrize(playerLotto);
        // then
        assertThat(prize).isEqualTo(expectedPrize);
    }
}