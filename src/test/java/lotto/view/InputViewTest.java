package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 당첨_번호_6개를_입력_받아_쉼표를_기준으로_구분() {
        // given
        String userInput = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when
        InputInfo info = inputView.inputWinningNumbers();
        // then
        assertEquals(true, info.isValidate());
        assertThat(inputView.splitUserInput(userInput)).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    void 담첨_번호가_숫자가_아닌_경우_예외처리() {
        // given
        String userInput = "가,나,다,라,마,바";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when
        InputInfo info = inputView.inputWinningNumbers();
        // then
        assertEquals(false, info.isValidate());
        assertEquals(ExceptionCode.INVALID_INPUT_INTEGER.getMessage(), info.getExceptionMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "0,3,4,2,5,6", "46,3,4,2,5,6" })
    void 담첨_번호가_1_부터_45_까지_폐구간_정수가_아닌_경우_예외처리(String testCase) {
        // given
        String userInput = testCase;
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        // when
        InputInfo info = inputView.inputWinningNumbers();
        // then
        assertEquals(false, info.isValidate());
        assertEquals(ExceptionCode.INVALID_INPUT_RANGE.getMessage(), info.getExceptionMessage());
    }
}
