package lotto.view;

import static lotto.constant.Message.PURCHASE_AMOUNT_PROMPT;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.dto.LottoPurchaseDto;
import lotto.model.LottoPurchaseAmount;
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

    @Test
    public void printPurchaseQuantity() {
        input("5000");
        LottoPurchaseAmount amount = LottoPurchaseAmount.from("5000");
        LottoPurchaseDto dto = new LottoPurchaseDto(amount.getAmount(), 5);
        lottoView.printPurchaseQuantity(dto);

        assertThat(getSystemOutput())
                .contains("5개를 구매했습니다");
    }
}