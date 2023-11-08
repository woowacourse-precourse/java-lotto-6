package lotto.domain;

import static lotto.utils.ConstantString.DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinnigMachineTest {

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
    void calculatePrize(String inputNumbers, String expectedPrize) {
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
        assertThat(prize.name()).isEqualTo(expectedPrize);
    }
}