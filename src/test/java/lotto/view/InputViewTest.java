package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionCode;

public class InputViewTest {
    InputView inputView = new InputView();

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 로또_구입_금액_입력_테스트() {
        // given
        String userInput = "14000";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when
        InputInfo info = inputView.inputPurchaseAmount();
        // then
        assertEquals(true, info.isValidate());
        assertEquals(14000, Integer.parseInt(info.getUserInput()));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "2147483648", "가나다라" })
    void 로또_구입_금액_입력_값이_0이상의_정수가_아닌_경우_예외처리(String testCase) {
        // given
        String userInput = testCase;
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when
        InputInfo info = inputView.inputPurchaseAmount();
        // then
        assertEquals(false, info.isValidate());
        assertEquals(ExceptionCode.INVALID_INPUT_INTEGER.getMessage(), info.getExceptionMessage());
    }

    @Test
    void 로또_구입_금액_입력_값이_1000원으로_나누어_떠어지지_않는_경우_예외처리() {
        // given
        String userInput = "1001";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when
        InputInfo info = inputView.inputPurchaseAmount();
        // then
        assertEquals(false, info.isValidate());
        assertEquals(ExceptionCode.INVALID_INPUT_DIVIDED.getMessage(), info.getExceptionMessage());
    }
}
