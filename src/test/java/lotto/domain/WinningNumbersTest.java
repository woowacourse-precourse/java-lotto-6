package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.NumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {
    Player player;

    @BeforeEach
    void beforeEach() {
        Player.deleteInstance();
        player = Player.getInstance();
    }

    @Test
    @DisplayName("추첨 숫자와 비교하여 같은 숫자를 알맞게 반환해야 한다.")
    public void calculateWinningNumberTest() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumber = List.of(1,2,3,4,8,9);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber,5);
        //when
        int winningCount = winningNumbers.calculateWinningNumber(lotto);
        //then
        assertThat(winningCount).isEqualTo(4);
    }

    @Test
    @DisplayName("보너스 숫자와 비교하여 같은 숫자를 알맞게 반환해야 한다.")
    public void calculateBonusNumberTest() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumber = List.of(1,2,3,4,8,9);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber,5);
        //when
        int bonusCount = winningNumbers.calculateBonusNumber(lotto);
        //then
        assertThat(bonusCount).isEqualTo(1);
    }

    @Test
    @DisplayName("추첨 번호의 개수는 6개여야 한다.")
    public void winningNumberCountTest() {
        //given
        assertThatThrownBy(() -> NumberValidator.validateNumberCount(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("추첨 번호는 중복되면 안된다.")
    public void winningNumberDuplicateTest() {
        //given
        assertThatThrownBy(() -> NumberValidator.validateDuplicate(List.of(1, 2, 3, 3, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("추첨 번호가 범위내에 없는 번호면 예외가 발생한다.")
    @CsvSource({"0,1,2,3,4,5,6", "1,2,3,4,5,46"})
    void createWinningNumberInRange(int first, int second, int third, int fourth, int fifth, int sixth) {
        assertThatThrownBy(() -> NumberValidator.validateRange(List.of(first, second, third, fourth, fifth, sixth)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호의 개수는 1개여야 한다.")
    public void bonusNumberCountTest() {
        //given
        assertThatThrownBy(() -> NumberValidator.validateNumberCount(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호는 추첨 번호들과 중복되면 안된다.")
    public void bonusNumberDuplicateTest() {
        //given
        assertThatThrownBy(() -> NumberValidator.validateInWinningNumbers(1,List.of(1, 2, 3, 3, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 범위내에 없는 번호면 예외가 발생한다.")
    @CsvSource({"0", "46"})
    void createBonusNumberInRange(int bonusNumber) {
        assertThatThrownBy(() -> NumberValidator.validateRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
