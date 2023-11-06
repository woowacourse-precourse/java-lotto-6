package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.utils.Converter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("구입 금액을 성공적으로 입력 받으면, 그 값을 정수형으로 반환한다.")
    @Test
    void readPurchaseAmount_Success() {
        // given
        System.setIn(createUserInput("8000"));

        // when
        int purchaseAmount = Converter.convertToInt(InputView.readPurchaseAmount());

        // then
        Assertions.assertThat(purchaseAmount).isEqualTo(8000);
    }

    @DisplayName("구입 금액 입력 시 숫자가 아닌 다른 문자를 입력하면 예외가 발생한다.")
    @Test
    void readPurchaseAmount_Fail_ByNotInteger() {
        // given
        System.setIn(createUserInput("hi"));

        // when, then
        Assertions.assertThatThrownBy(() -> Converter.convertToInt(InputView.readPurchaseAmount()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
    }

    @DisplayName("당첨 번호를 성공적으로 입력 받으면, 각 번호를 원소로 가지는 리스트를 반환한다.")
    @Test
    void readWinningNumbers_Success() {
        // given
        System.setIn(createUserInput("1,2,3,4,5,6"));

        // when
        List<Integer> winningNumbers =
                Converter.convertToIntegerList(InputView.readWinningNumbers());

        // then
        Assertions.assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호 입력 시 주어진 입력 형식과 일치하지 않으면 예외가 발생한다.")
    @Test
    void readWinningNumbers_ByInvalidNumbersRegex() {
        // given
        System.setIn(createUserInput("1,f,2,6,7,10"));

        // when
        Assertions.assertThatThrownBy(() ->
                        Converter.convertToIntegerList(InputView.readWinningNumbers()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_REGEX_INPUT.getMessage());
    }

    @DisplayName("보너스 번호를 성공적으로 입력 받으면, 그 값을 정수형으로 반환한다.")
    @Test
    void readBonusNumber_Success() {
        // given
        System.setIn(createUserInput("7"));

        // when
        int bonusNumber = Converter.convertToInt(InputView.readBonusNumber());

        // then
        Assertions.assertThat(bonusNumber).isEqualTo(7);
    }

    @DisplayName("보너스 번호 입력 시 숫자가 아닌 다른 문자를 입력하면 예외가 발생한다.")
    @Test
    void readBonusNumber_Fail_ByNotInteger() {
        // given
        System.setIn(createUserInput("notNumber"));

        // when, then
        Assertions.assertThatThrownBy(() -> Converter.convertToInt(InputView.readBonusNumber()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
    }

    @DisplayName("값 입력 시 공백이 포함되어 있으면 예외가 발생한다.")
    @Test
    void read_Fail_ByContainsBlank() {
        // given
        System.setIn(createUserInput(" 2"));

        // when, then
        Assertions.assertThatThrownBy(InputView::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CONTAINS_BLANK_INPUT.getMessage());
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
