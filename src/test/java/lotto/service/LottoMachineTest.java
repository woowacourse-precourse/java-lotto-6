package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @Nested
    @DisplayName("issuedLottos 메소드 test")
    class IssuedLottos {
        @DisplayName("발행된 로또 수는 구입 금액을 " + PurchaseAmountDto.PURCHASE_AMOUNT_UNIT + "으로 나눈 값과 같다")
        @Test
        void Issued_lotto_count_is_equal_to_purchase_amount() {
            // given
            PurchaseAmountDto purchaseAmountDto = new PurchaseAmountDto(5000);
            LottoMachine lottoMachine = new LottoMachine();

            // when
            LottosDto lottosDto = lottoMachine.issuedLottos(purchaseAmountDto);

            // then
            assertThat(lottosDto.lottos().size()).isEqualTo(
                    purchaseAmountDto.amount() / PurchaseAmountDto.PURCHASE_AMOUNT_UNIT);
        }
    }
}