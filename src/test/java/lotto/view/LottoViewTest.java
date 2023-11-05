package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.controller.dto.output.PurchasedLottosDto;
import lotto.mock.MockReader;
import lotto.mock.MockWriter;
import lotto.view.constants.LottoMessage;
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
        assertThat(writer.getOutput()).isEqualTo(LottoMessage.INPUT_LOTTO_PURCHASE_AMOUNT.getMessage());
        assertThat(lottoPurchaseAmountDto.purchaseAmount()).isEqualTo(amount);
    }

    @Test
    void 구매로또출력_화면_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(6, 10, 16, 34, 35, 43)));
        PurchasedLottosDto purchasedLottosDto = new PurchasedLottosDto(lottos);
        //when
        lottoView.showPurchasedLottos(purchasedLottosDto);
        //then
        String expected = """
                2개를 구매했습니다.
                [1, 2, 3, 4, 5, 6]
                [6, 10, 16, 34, 35, 43]
                                
                """;
        assertThat(writer.getOutput()).isEqualTo(expected);
    }
}