package lotto.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UiTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 구매가격입력을_출력한다() {
        final String expectMessage = "구입금액을 입력해 주세요.";
        Ui ui = new Ui();
        ui.printPrice();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectMessage);
    }

    @Test
    void 로또구매현황을_출력한다() {
        final String expectMessage = "3개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 7]\n[7, 11, 15, 22, 33, 44]";
        Ui ui = new Ui();
        ui.printLotto(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(11, 22, 33, 44, 15, 7))
        ));
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualToIgnoringNewLines(expectMessage);
    }
}