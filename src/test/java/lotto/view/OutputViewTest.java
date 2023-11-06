package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("구입 금액 입력 안내")
    void outputPurchaseAmount() {
        System.setIn(new ByteArrayInputStream("14000".getBytes()));
        outputView.outputPurchasePrice();
    }
}