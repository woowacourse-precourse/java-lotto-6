package lotto.View;

import static org.assertj.core.api.Assertions.assertThatCode;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


class InputViewTest {

    @Test
    void 구입금액을_정상적으로_입력시_통과() {
        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Console.close();

        assertThatCode(() -> InputView.inputAmount()).doesNotThrowAnyException();
    }

    @Test
    void 당첨번호를_정상적으로_입력시_통과() {
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Console.close();

        assertThatCode(() -> InputView.inputWinningNumbers()).doesNotThrowAnyException();
    }

    @Test
    void 보너스번호를_정상적으로_입력시_통과(){
        String input = "7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Console.close();

        assertThatCode(() -> InputView.inputBonusNumber()).doesNotThrowAnyException();
    }

}
