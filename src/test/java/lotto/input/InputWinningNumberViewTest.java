package lotto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.view.InputWinningNumberView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputWinningNumberViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("당첨번호 입력 시 빈 값이 들어오면 에러")
    @Test
    void checkEmpty() {
        String input = "\0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(InputWinningNumberView::inputWinningNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 형식에 맞지 않으면 에러")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,4,5,6,",
            "1.2.3.4.5.6",
            "1,2,3,4",
            "1,2,3,4,5,6,7",
            "1 ,2,3,4,5,6",
            "q,1,2,3,4,5,6"
    })
    void checkFormat(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(InputWinningNumberView::inputWinningNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
