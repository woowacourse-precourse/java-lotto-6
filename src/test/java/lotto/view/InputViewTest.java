package lotto.view;

import static lotto.constant.ErrorMessage.BLANK_INPUT;
import static lotto.constant.ErrorMessage.EXCEEDED_MAXIMUM_NUMBER_FORMAT;
import static lotto.constant.ErrorMessage.INPUT_NOT_DIGIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Nested
    @DisplayName("구매 금액을 입력 받는다.")
    class getPurChaseAmount {

        @DisplayName("[성공] 입력값이 적절한 형식으로 변환된다.")
        @Test
        void getPurchaseAmount() {
            // given
            InputView inputView = new InputView();
            String input = "1000";
            Long expected = Long.parseLong(input);
            System.setIn(createUserInput(input));

            // when
            Long result = inputView.getPurchaseAmount();

            // then
            assertThat(result).isEqualTo(expected);
        }

        @DisplayName("[실패] 입력값이 공백이면 예외가 발생한다.")
        @Test
        void exception_Blank() {
            // given
            InputView inputView = new InputView();
            String input = "    ";
            System.setIn(createUserInput(input));

            // when  then
            assertThatThrownBy(inputView::getPurchaseAmount)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BLANK_INPUT.toString());
        }

        @DisplayName("[실패] 입력값이 숫자가 아니면 예외가 발생한다.")
        @Test
        void exception_Not_Digit_Input() {
            // given
            InputView inputView = new InputView();
            String input = "+01a";
            System.setIn(createUserInput(input));

            // when  then
            assertThatThrownBy(inputView::getPurchaseAmount)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INPUT_NOT_DIGIT.toString());
        }

        @DisplayName("[실패] 입력값이 지정된 형식의 최댓값보다 크면 예외가 발생한다.")
        @Test
        void exception_Exceeded_Maximum_Type_Value() {
            // given
            InputView inputView = new InputView();
            String input = "9223372036854775808";
            System.setIn(createUserInput(input));

            // when  then
            assertThatThrownBy(inputView::getPurchaseAmount)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(EXCEEDED_MAXIMUM_NUMBER_FORMAT.toString());
        }
    }

    @Nested
    @DisplayName("당첨 번호를 입력 받는다.")
    class getWinningNumbers {

        @DisplayName("[성공] 입력값이 적절한 형식으로 변환된다.")
        @Test
        void getWinningNumbersGood() {
            // given
            InputView inputView = new InputView();
            String input = "1,2,3,4,5,6";
            List<Integer> expected = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .toList();
            System.setIn(createUserInput(input));

            // when
            List<Integer> result = inputView.getWinningNumbers();

            // then
            assertThat(result).isEqualTo(expected);
        }

        @DisplayName("[실패] 입력값이 공백이면 예외가 발생한다.")
        @Test
        void exception_Blank() {
            // given
            InputView inputView = new InputView();
            String input = "1,  ,2,3,4,5,6";
            System.setIn(createUserInput(input));

            // when  then
            assertThatThrownBy(inputView::getWinningNumbers)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BLANK_INPUT.toString());
        }

        @DisplayName("[실패] 입력값이 숫자가 아니면 예외가 발생한다.")
        @Test
        void exception_Not_Digit_Input() {
            // given
            InputView inputView = new InputView();
            String input = "1,2,3,4,5,a+01a";
            System.setIn(createUserInput(input));

            // when  then
            assertThatThrownBy(inputView::getWinningNumbers)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INPUT_NOT_DIGIT.toString());
        }

        @DisplayName("[실패] 입력값이 지정된 형식의 최댓값보다 크면 예외가 발생한다.")
        @Test
        void exception_Exceeded_Maximum_Type_Value() {
            // given
            InputView inputView = new InputView();
            String input = "1,2,3,4,5,9223372036854775808";
            System.setIn(createUserInput(input));

            // when  then
            assertThatThrownBy(inputView::getWinningNumbers)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(EXCEEDED_MAXIMUM_NUMBER_FORMAT.toString());
        }
    }

    @Nested
    @DisplayName("보너스 번호를 입력 받는다.")
    class getBonusNumber {

        @DisplayName("[성공] 입력값이 적절한 형식으로 변환된다.")
        @Test
        void getPurchaseAmount() {
            // given
            InputView inputView = new InputView();
            String input = "1";
            int expected = Integer.parseInt(input);
            System.setIn(createUserInput(input));

            // when
            int result = inputView.getBonusNumber();

            // then
            assertThat(result).isEqualTo(expected);
        }

        @DisplayName("[실패] 입력값이 공백이면 예외가 발생한다.")
        @Test
        void exception_Blank() {
            // given
            InputView inputView = new InputView();
            String input = "    ";
            System.setIn(createUserInput(input));

            // when  then
            assertThatThrownBy(inputView::getBonusNumber)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BLANK_INPUT.toString());
        }

        @DisplayName("[실패] 입력값이 숫자가 아니면 예외가 발생한다.")
        @Test
        void exception_Not_Digit_Input() {
            // given
            InputView inputView = new InputView();
            String input = "+01a";
            System.setIn(createUserInput(input));

            // when  then
            assertThatThrownBy(inputView::getBonusNumber)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INPUT_NOT_DIGIT.toString());
        }

        @DisplayName("[실패] 입력값이 지정된 형식의 최댓값보다 크면 예외가 발생한다.")
        @Test
        void exception_Exceeded_Maximum_Type_Value() {
            // given
            InputView inputView = new InputView();
            String input = "9223372036854775808";
            System.setIn(createUserInput(input));

            // when  then
            assertThatThrownBy(inputView::getBonusNumber)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(EXCEEDED_MAXIMUM_NUMBER_FORMAT.toString());
        }
    }


    private InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
