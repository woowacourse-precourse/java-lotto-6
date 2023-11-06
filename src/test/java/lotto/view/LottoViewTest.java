package lotto.view;

import static lotto.constant.Message.PURCHASE_AMOUNT_PROMPT;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.template.UiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoViewTest extends UiTest {
    LottoView lottoView;


    @BeforeEach
    void setUp() {
        lottoView = LottoView.create();
    }

    @Test
    void printMessageTest() {
        lottoView.printMessage(PURCHASE_AMOUNT_PROMPT);

        assertThat(getSystemOutput()).contains(PURCHASE_AMOUNT_PROMPT.getMessage());
    }

    @Test
    void askPurchaseAmount() {
        input("5000");
        String inputAmount = lottoView.askPurchaseAmount();

        assertThat(inputAmount).isEqualTo("5000");
    }
}