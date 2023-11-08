package lotto.view;

import static lotto.constant.OutputText.ENTER_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @DisplayName("구매금액_요청_출력_테스트")
    @Test
    void printEnterPurchaseAmount() {
        OutputView outputView = new OutputView();
        outputView.printEnterPurchaseAmount();
        assertThat(output()).isEqualTo(ENTER_PURCHASE_AMOUNT.toString());
    }
}
