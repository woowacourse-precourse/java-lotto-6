package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.dto.LottoPurchaseInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseInfoTest {
    @Test
    @DisplayName("구매 금액에 맞게 lotto 개수를 생성한다.")
    void createNumberOfLottoPurchasedByPurchasedAmount() {
        assertThat(new LottoPurchaseInfo(new BigDecimal(321000), Lotto.PRICE).getNumberOfLottoPurchased()
                .compareTo(BigDecimal.valueOf(321)))
                .isEqualTo(0);
    }
}
