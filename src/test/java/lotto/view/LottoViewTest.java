package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.mock.MockReader;
import lotto.mock.MockWriter;
import org.junit.jupiter.api.Test;

class LottoViewTest {
    private final MockReader reader = new MockReader();
    private final MockWriter writer = new MockWriter();
    private final LottoView lottoView = new LottoView(reader, writer);

    @Test
    void 로또구입금액_입력_화면_테스트() {
        //given
        String amount = "20000";
        reader.setInput(amount);
        //when
        LottoPurchaseAmountDto lottoPurchaseAmountDto = lottoView.inputLottoPurchaseAmount();
        //then
        assertThat(writer.getOutput()).isEqualTo(
                LottoMessage.INPUT_LOTTO_PURCHASE_AMOUNT.getMessage());
        assertThat(lottoPurchaseAmountDto.purchaseAmount()).isEqualTo(amount);
    }
}