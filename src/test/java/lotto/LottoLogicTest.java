package lotto;

import static lotto.message.ErrorMessage.AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import lotto.domain.LottoLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoLogicTest {
    @Test
    @DisplayName("로또 구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    void lottoAmountIsNotInThousandWonUnits() {
        assertThatThrownBy(() -> new LottoLogic(BigDecimal.valueOf(2002), Lotto.PRICE, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS.getMessage());
    }

    @Test
    @DisplayName("보너스 로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    void BonusNumberIsNotInCorrectRange() {
        assertThatThrownBy(() -> new LottoLogic(BigDecimal.valueOf(2000), Lotto.PRICE, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
    }

    @Test
    @DisplayName("구매 금액에 맞게 lotto 개수를 생성한다.")
    void createNumberOfLottoPurchasedByPurchasedAmount() {
        assertThat(new LottoLogic(BigDecimal.valueOf(321000), Lotto.PRICE, 1).numberOfLottoPurchased
                .compareTo(BigDecimal.valueOf(321)))
                .isEqualTo(0);
    }
}
