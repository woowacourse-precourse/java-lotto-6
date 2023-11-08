package lotto.modelTest;

import lotto.validator.WinningNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @Test
    void inputMoneyNullOrEmpty() {
        String[] test1 = {};
        assertThatThrownBy(() -> new WinningNumbers(test1))
                .isInstanceOf(IllegalArgumentException.class);

        String[] test2 = {" ", " ", " ", " ", " ", " "};
        assertThatThrownBy(() -> new WinningNumbers(test2))
                .isInstanceOf(IllegalArgumentException.class);

        String[] test3 = {"1", "2", "3", "4", "5",};
        assertThatThrownBy(() -> new WinningNumbers(test3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumbersCount() {
        String[] test1 = {"1", "2", "3"};
        assertThatThrownBy(() -> new WinningNumbers(test1))
                .isInstanceOf(IllegalArgumentException.class);

        String[] test2 = {"1", "2", "3", "4", "5", "6", "7"};
        assertThatThrownBy(() -> new WinningNumbers(test2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNoDuplicates() {
        String[] test1 = {"1", "1", "1", "1", "1", "1"};
        assertThatThrownBy(() -> new WinningNumbers(test1))
                .isInstanceOf(IllegalArgumentException.class);

        String[] test2 = {"1", "2", "3", "4", "6", "6"};
        assertThatThrownBy(() -> new WinningNumbers(test2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateTypeInput() {
        String[] test1 = {"일", "2", "3", "4", "5", "6"};
        assertThatThrownBy(() -> new WinningNumbers(test1))
                .isInstanceOf(IllegalArgumentException.class);

        String[] test2 = {"1.2", "2", "3", "4", "5", "6"};
        assertThatThrownBy(() -> new WinningNumbers(test2))
                .isInstanceOf(IllegalArgumentException.class);

        String[] test3 = {"one", "2", "3", "4", "6", "6"};
        assertThatThrownBy(() -> new WinningNumbers(test3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumberInRange() {
        String[] test1 = {"0", "2", "3", "4", "5", "6"};
        assertThatThrownBy(() -> new WinningNumbers(test1))
                .isInstanceOf(IllegalArgumentException.class);

        String[] test2 = {"-1", "2", "3", "4", "5", "6"};
        assertThatThrownBy(() -> new WinningNumbers(test2))
                .isInstanceOf(IllegalArgumentException.class);

        String[] test3 = {"46", "2", "3", "4", "6", "6"};
        assertThatThrownBy(() -> new WinningNumbers(test3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
