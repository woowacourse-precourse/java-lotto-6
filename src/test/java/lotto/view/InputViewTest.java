package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

class InputViewTest {


    @AfterEach
    public void closeScanner() {
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,2,3,4,5,6", "a,1,2,3,4,5", "1,2,3", "1,2,3,4,5,6,7", "1,2,3,4,5,6,"})
    public void 당첨번호_입력_값의_형식이_올바르지_않으면_예외를_발생시킨다(String input) {
        // given
        systemIn(input);

        // when, then
        Assertions.assertThatThrownBy(InputView::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void systemIn(String input) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
    }

}