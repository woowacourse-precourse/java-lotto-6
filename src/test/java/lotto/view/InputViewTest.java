package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.exception.Exception.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.Exception.DUPLICATE_WINNING_NUMBER;
import static lotto.exception.Exception.INVALID_BONUS_NUMBER_INPUT_TYPE;
import static lotto.exception.Exception.INVALID_NUMBER_RANGE;
import static lotto.exception.Exception.INVALID_WINNING_NUMBERS_INPUT_TYPE;
import static lotto.exception.Exception.ONLY_NUMERIC_INPUT_FOR_MONEY;
import static lotto.exception.Exception.WINNING_NUMBERS_SIZE_SHOULD_BE_SIX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {
    @Nested
    class 구입금액_입력_테스트 extends NsTest {

        @DisplayName("구입금액이 숫자가 아닌 경우 예외가 발생되는가.")
        @Test
        void inputMoney() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("input"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ONLY_NUMERIC_INPUT_FOR_MONEY.getMessage());
            });
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            inputView.inputMoney();
        }
    }

    @Nested
    class 당첨번호_입력_테스트 extends NsTest {
        @DisplayName("당첨번호 입력시 6개가 아닌 경우 예외가 발생하는가")
        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5", "1,2,3,4,5,6,7"}, delimiter = ',')
        void inputWinningNumbersByOverSize(String input) {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(WINNING_NUMBERS_SIZE_SHOULD_BE_SIX.getMessage());
            });
        }

        @DisplayName("당첨번호 입력시 숫자가 중복된 경우 예외가 발생하는가")
        @Test
        void inputWinningNumbersByDuplication() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("1, 1, 1, 1, 1, 1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(DUPLICATE_WINNING_NUMBER.getMessage());
            });
        }

        @DisplayName("당첨번호 입력시 숫자와 구분자, 공백이 아닌 다른 문자가 포함된 경우 예외가 발생하는가")
        @Test
        void inputWinningNumbersByInvalidType() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("1.2.3.4.8.6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_WINNING_NUMBERS_INPUT_TYPE.getMessage());
            });
        }

        @DisplayName("당첨번호에 공백이 있는 경우 제거하는가")
        @Test
        void inputWinningNumbersWithSpace() {
            assertSimpleTest(() -> {
                run("1,2,3,4,  5, 7");
                assertThat(output()).contains("1", "2", "3", "4", "5", "7");
            });
        }

        @DisplayName("당첨번호가 1~45 사이의 수가 아닌 경우 예외가 발생하는가")
        @Test
        void inputWinningNumbers() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("1,2,3,4, 50, 6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_NUMBER_RANGE.getMessage());
            });
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            System.out.println(winningNumbers);
        }
    }

    @Nested
    class 보너스번호_입력_테스트 extends NsTest {
        @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생하는가")
        @Test
        void inputBonusNumberByInvalidType() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_BONUS_NUMBER_INPUT_TYPE.getMessage());
            });
        }
        @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외가 발생하는가")
        @Test
        void inputBonusNumberByDuplication() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(DUPLICATE_BONUS_NUMBER.getMessage());
            });
        }

        @Override
        protected void runMain() {
            List<Integer> validWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
            InputView inputView = new InputView();
            inputView.inputBonusNumber(validWinningNumbers);
        }
    }
}
