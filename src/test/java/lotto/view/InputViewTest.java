package lotto.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import lotto.enums.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void closeConsole() {
        Console.close();
        System.setOut(System.out);
    }

    @DisplayName("(구입 금액) 입력에 문자가 들어오면 예외가 발생한다.")
    @Test
    void invalidPurchaseAmountTest() {
        System.setIn(createUserInput("asdf"));

        assertThatThrownBy(() -> inputView.readPurchaseAmount())
            .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("(당첨 번호) 입력에 문자가 들어오면 예외가 발생한다.")
    @Test
    void invalidWinningNumberTest() {
        System.setIn(createUserInput("asdf"));
        assertThatThrownBy(() -> inputView.readWinningNumbers())
            .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("(보너스 번호) 입력에 문자가 들어오면 예외가 발생한다.")
    @Test
    void invalidBonusNumberTest() {
        System.setIn(createUserInput("asdf"));
        assertThatThrownBy(() -> inputView.readBonusNumber())
            .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("(구입 금액) 입력에 공백이 들어오면 예외가 발생한다.")
    @Test
    void emptyInputPurchaseAmountTest() {
        System.setIn(createUserInput(" "));

        assertThatThrownBy(() -> inputView.readPurchaseAmount())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("(당첨 번호) 입력에 공백이 들어오면 예외가 발생한다.")
    @Test
    void emptyInputWinningNumberTest() {
        System.setIn(createUserInput(" "));
        assertThatThrownBy(() -> inputView.readWinningNumbers())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("(보너스 번호) 입력에 공백이 들어오면 예외가 발생한다.")
    @Test
    void emptyInputBonusNumberTest() {
        System.setIn(createUserInput(" "));
        assertThatThrownBy(() -> inputView.readBonusNumber())
            .isInstanceOf(IllegalArgumentException.class);
    }


    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}