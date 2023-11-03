package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.LottoSeller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoSellerTest {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR]";
    private static final int LOTTO_PRICE = 1000;

    @DisplayName("기능 2번, 입력한 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void notNumberAmountInput() {
        String userInput = "1000원";
        LottoSeller lottoSeller = new LottoSeller();
        assertThatThrownBy(() -> lottoSeller.getAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEADER + " 숫자만 입력해주세요.");
    }

    @DisplayName("기능 2번, 입력한 구매 금액이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void notDividedByLottoPrice() {
        String userInput = "1500";
        LottoSeller lottoSeller = new LottoSeller();
        assertThatThrownBy(() -> lottoSeller.getAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEADER + " " + LOTTO_PRICE + " 단위로만 입력하세요.");
    }
}
