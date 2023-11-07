package lotto.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.controller.UserInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class UserInputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("사용자 로또 금액 입력 테스트")
    @Test
    void inputPrice_test() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("4000".getBytes());
        System.setIn(in);

        // when/then
        assertThatCode(UserInput::inputPrice).doesNotThrowAnyException();
    }

    @DisplayName("사용자 로또 금액 입력 테스트")
    @Test
    void inputPrice_test_exception() {
        // Given
        String dataWithNewLine = "4001\n4000\n"; // 유효하지 않은 입력과 유효한 입력이 줄바꿈 단위로 들어감.
        ByteArrayInputStream in = new ByteArrayInputStream(dataWithNewLine.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        assertTimeoutPreemptively(Duration.ofSeconds(5), UserInput::inputPrice);

        // Then
        String output = outContent.toString();
        assertThat(output).contains(ERROR_MESSAGE);

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @DisplayName("사용자 당첨 번호 입력 테스트")
    @Test
    void inputWinningLotto_test() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(in);

        // when/then
        assertThatCode(UserInput::inputWinningLotto).doesNotThrowAnyException();
    }

    @DisplayName("사용자 당첨 번호 입력 테스트 - 실패 예시")
    @Test
    void inputWinningLotto_test_exception() {
        // given
        String dataWithNewLine = "1, 2, 3, 4, 5, 6\n1,2,3,4,5,6\n"; // 유효하지 않은 입력과 유효한 입력이 줄바꿈 단위로 들어감.
        ByteArrayInputStream in = new ByteArrayInputStream(dataWithNewLine.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // when/then
        assertTimeoutPreemptively(Duration.ofSeconds(5), UserInput::inputWinningLotto);

        // Then
        String output = outContent.toString();
        assertThat(output).contains(ERROR_MESSAGE);

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
