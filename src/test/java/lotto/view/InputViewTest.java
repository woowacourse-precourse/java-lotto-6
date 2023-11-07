package lotto.view;

import static lotto.enums.ErrorMessage.ACCOUNT_UNIT_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Timer;
import lotto.enums.ErrorMessage;
import lotto.enums.OutputMessage;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class InputViewTest {

    private InputView inputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    /**
     * PurchaseAccount 로직 검증을 위한 테스트
     */
    @DisplayName("구입 금액이 제대로 입력되는지 확인한다.")
    @Test
    void inputNormalAccount() {
        // given
        System.setIn(createUserInput("8000"));

        // when, then
        Assertions.assertThat(inputView.readPurchaseAmount()).isEqualTo(8000);
    }

    /**
     * @DisplayName("구입 금액에 음수가 입력되면 예외 메시지가 출력된다")
     *     @Test
     *     void inputNegativeAccount() {
     *         // given
     *         System.setIn(createUserInput("-1000"));
     *
     *         // when
     *         inputView.readPurchaseAmount();
     *
     *         // then
     *         String consoleOutput = outputStream.toString();
     *         assertThat(consoleOutput).contains(ErrorMessage.NEGATIVE_NUM_ERROR.getMessage());
     *
     *     }
     */

    @DisplayName("구입 금액에 음수가 입력되면 예외 메시지가 출력된다")
    @Test
    void inputNegativeAccount1() {
        // given
        System.setIn(createUserInput("-1000"));

        // when, then
        assertThatThrownBy(() -> inputView.readPurchaseAmount())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 음수가 입력되면 예외 메시지가 출력된다")
    @Test
    void inputNegativeAccount() {
        // given
        System.setIn(createUserInput("-1000"));

        // when, then
        assertThatThrownBy(() -> inputView.readPurchaseAmount())
            .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("구입 금액에 숫자가 아닌 수가 입력되면 예외가 발생한다")
    @Test
    void inputInvalidAccount() {
        // given
        System.setIn(createUserInput("100a"));

        // when, then
        assertThatThrownBy(() -> inputView.readPurchaseAmount())
            .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구입 금액이 1000원을 넘지 않으면 예외가 발생한다")
    @Test
    void inputSmallAccount() {
        // given
        System.setIn(createUserInput("100"));

        // when, then
        assertThatThrownBy(() -> inputView.readPurchaseAmount())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위로 입력되지 않으면 예외가 발생한다")
    @Test
    void inputNotMultipleOf1000() {
        // given
        System.setIn(createUserInput("1234"));

        // when, then
        assertThatThrownBy(() -> inputView.readPurchaseAmount())
            .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     *
     * WinningNumbers 로직 검증을 위한 테스트
     */
    @DisplayName("")
    @Test


    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}