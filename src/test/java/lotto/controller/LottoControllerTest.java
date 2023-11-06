package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {
    @DisplayName("숫자가 아닌 구입 금액")
    @Test
    void requestInteger() {
        // given
        InputView inputView = InputView.getInstance();
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        // then
        assertThatThrownBy(inputView::requestInteger)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수를 입력해야 합니다.");

        Console.close();
    }

    @DisplayName("숫자가 아닌 로또 번호")
    @Test
    void requestWinningLotto() {
        InputView inputView = InputView.getInstance();
        String input = "1,4,2,10,6,42j";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThatThrownBy(inputView::requestIntegers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표(,)로 구분된 정수를 입력해야 합니다.");

        Console.close();
    }

    @DisplayName("숫자가 아닌 보너스 번호")
    @Test
    void requestBonusNumber() {
        InputView inputView = InputView.getInstance();
        String input = "0.5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThatThrownBy(inputView::requestInteger)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수를 입력해야 합니다.");

        Console.close();
    }
}