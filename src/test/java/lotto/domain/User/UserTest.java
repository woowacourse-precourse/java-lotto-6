package lotto.domain.User;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.Lotto.Lotto;
import lotto.util.InputUtil;
import lotto.validator.InputValidator;
import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";
    InputValidator validator = new InputValidator();
    ByteArrayOutputStream outputContent;

    @BeforeEach
    void setUpStreams() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("구입 금액이 숫자가 아닌 경우 예외 발생 및 에러메시지 출력 확인")
    @Test
    void checkAmountNumberTest() {
        assertThatThrownBy(() -> validator.checkAmount("8000j"))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

    @DisplayName("구입 금액이 양수가 아닌 경우 예외 발생 및 에러메시지 출력 확인")
    @Test
    void checkAmountPositiveNumberTest() {
        assertThatThrownBy(() -> validator.checkAmount("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않는 경우 예외 발생 및 에러메시지 출력 확인")
    @Test
    void checkDividedNumberTest() {
        assertThatThrownBy(() -> validator.checkAmount("8008"))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
