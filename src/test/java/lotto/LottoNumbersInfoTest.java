package lotto;

import static lotto.message.ErrorMessage.AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.List;
import lotto.dto.LottoPurchaseInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersInfoTest {
    @Test
    @DisplayName("로또 구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    void lottoAmountIsNotInThousandWonUnits() {
        assertThatThrownBy(() -> new LottoPurchaseInfo(BigDecimal.valueOf(321321), Lotto.PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS.getMessage());
    }

    @Test
    @DisplayName("보너스 로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    void BonusNumberIsNotInCorrectRange() {
        assertThatThrownBy(() -> new lotto.dto.LottoNumbersInfo(List.of(), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
    }
}
