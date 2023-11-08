package lotto.lotto;

import static lotto.error.message.InvalidStateErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.error.message.InvalidStateErrorMessage.PURCHASE_AMOUNT_UNDER_LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.exception.InvalidStateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoVendorTest {
    LottoVendor lottoVendor = new LottoVendor();

    @DisplayName("구입 금액이 1000원 이하일 경우 예외가 발생한다.")
    @Test
    void generateLottosByPurchaseAmountUnderThousand() {
        assertThatThrownBy(() -> lottoVendor.generateLottos(500))
                .isInstanceOf(InvalidStateException.class)
                .extracting("message")
                .isEqualTo(PURCHASE_AMOUNT_UNDER_LOTTO_PRICE.getMessage());
    }

    @DisplayName("구입 금액이 1000의 배수가 아닐 경우 예외가 발생한다.")
    @Test
    void generateLottosByPurchaseAmountNotMultipleOfThousand() {
        assertThatThrownBy(() -> lottoVendor.generateLottos(11111))
                .isInstanceOf(InvalidStateException.class)
                .extracting("message")
                .isEqualTo(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
    }

    @DisplayName("구입 금액만큼 로또가 생성된다.")
    @Test
    void generateLottosWithProperCount() {
        for (int purchaseCount = 1; purchaseCount <= 100; purchaseCount += 1) {
            List<Lotto> lottos = lottoVendor.generateLottos(purchaseCount * 1000);
            assertThat(lottos.size()).isEqualTo(purchaseCount);
        }
    }
}