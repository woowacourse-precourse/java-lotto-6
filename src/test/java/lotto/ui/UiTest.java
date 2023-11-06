package lotto.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

}