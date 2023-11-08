package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    private final LottoStore lottoPublisher = new LottoStore();

    @Test
    public void 올바르지_않은_금액으로_발행할_시_예외가_발생한다() {
        String notPositiveAmountInput = "-1";
        String nonDividedAmountInput = "1111";

        Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
            lottoPublisher.purchaseLottoTickets(notPositiveAmountInput);
        });
        assertThat(e1.getMessage()).isEqualTo("[ERROR] 로또 구매 금액은 양수여야 합니다.");

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
            lottoPublisher.purchaseLottoTickets(nonDividedAmountInput);
        });
        assertThat(e2.getMessage()).isEqualTo("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다.");
    }
}
