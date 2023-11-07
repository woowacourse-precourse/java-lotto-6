package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputException;

class InputExceptionTest {
    private static final String LETTER = "test";
    private static final String NUMBER_LETTER = "1234";
    private static final String BONUS_NUMBER = "6";

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void canBeConvertedToInteger() {
        assertThatThrownBy(() -> InputException.canBeConvertedToInteger(LETTER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void isValidAmount() {
        assertThatThrownBy(() -> InputException.isValidAmount(NUMBER_LETTER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45 사이가 아니면 예외가 발생한다.")
    @Test
    void isNumberInRange() {
        assertThatThrownBy(() -> InputException.isNumberInRange(NUMBER_LETTER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void hasSixNumbers() {
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7"};
        assertThatThrownBy(() -> InputException.hasSixNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void hasNoDuplicateNumbers() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "6");

        assertThatThrownBy(() -> InputException.hasNoDuplicateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void isInWinningNumbers() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> InputException.isInWinningNumbers(numbers, BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }
}