package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_MONEY;
import static lotto.message.ErrorMessage.NUMBER_FORMAT_WINNING_NUMBERS;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_LENGTH;
import static lotto.message.ErrorMessage.WINNING_NUMBERS_RANGE;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.view.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputWinningNumbersTest extends NsTest {
    Input input = new Input();

    @Test
    @DisplayName("유효한 당첨 번호 입력 테스트")
    void getValidWinningNumbers_test() {
        command("1,2,3,4,5,6");
        List<Integer> winningNumbersTest = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(input.getValidWinningNumbers()).isEqualTo(winningNumbersTest);
    }

    @Test
    @DisplayName("6개가 아닌 당첨번호 입력 시 예외 테스트")
    void validateWinningNumbersLength_test() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,6,7");
            assertThat(output()).contains(WINNING_NUMBERS_LENGTH.errorMessage());
        });
    }

    @Test
    @DisplayName("1~45 범위 밖의 당첨번호 입력 시 예외 테스트")
    void validateWinningNumbersRange_test() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,1000");
            assertThat(output()).contains(WINNING_NUMBERS_RANGE.errorMessage());
        });
    }

    @Test
    @DisplayName("숫자가 아닌 당첨번호 입력 시 예외 테스트")
    void validateNonNumericalWinningNumbers_test() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,pobi");
            assertThat(output()).contains(NUMBER_FORMAT_WINNING_NUMBERS.errorMessage());
        });
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {
        input.getValidWinningNumbers();
    }
}
