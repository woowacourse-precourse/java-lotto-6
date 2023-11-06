package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("구입 금액이 제대로 입력되는지 확인한다.")
    @Test
    void inputNormalAccount() {
        // given
        System.setIn(createUserInput("8000"));

        // when, then
        Assertions.assertThat(inputView.readPurchaseAccount()).isEqualTo(8000);
    }

    @DisplayName("구입 금액에 숫자가 아닌 수가 입력되면 예외가 발생한다")
    @Test
    void inputInvalidAccount1() {
        // given
        System.setIn(createUserInput("-1000"));
        /**
         * System.setIn(createUserInput("100a"));
         * System.setIn(createUserInput("92qefe2"));
         * System.setIn(createUserInput("1921.323"));
         */

        // when, then
        assertThatThrownBy(() -> inputView.readPurchaseAccount())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자가 아닌 수가 입력되면 예외가 발생한다")
    @Test
    void inputInvalidAccount2() {
        //TODO 이건 기본적으로 입력을 받을 때 int값만 받도록 지정했기 때문에 자동 예외 처리가 된다.
        // 이 부분 어떻게 해결할지 고민 필요

        // given
        System.setIn(createUserInput("100a"));

        // when, then
        assertThatThrownBy(() -> inputView.readPurchaseAccount())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원을 넘지 않으면 예외가 발생한다")
    @Test
    void inputSmallAccount() {
        // given
        System.setIn(createUserInput("100"));

        // when, then
        assertThatThrownBy(() -> inputView.readPurchaseAccount())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위로 입력되지 않으면 예외가 발생한다")
    @Test
    void inputNotMultipleOf1000() {
        // given
        System.setIn(createUserInput("1234"));

        // when, then
        assertThatThrownBy(() -> inputView.readPurchaseAccount())
            .isInstanceOf(IllegalArgumentException.class);
    }



    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}