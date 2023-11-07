package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoSellerTest {

    @DisplayName("구매자가 구입 금액으로 판매자에게 로또 티켓들을 받는 기능")
    @Test
    void lottoBuyerPurchaseLottoTickets() {

        int validPurchaseAmount = 10000;
        int invalidPurchaseAmount = 10500;
        int expectedResultSize = 10;
        LottoSeller lottoSeller = new LottoSeller();

        List<Lotto> tickets = lottoSeller.exchangeTickets(validPurchaseAmount);
        assertEquals(tickets.size(), expectedResultSize);

        assertThatThrownBy(() -> lottoSeller.exchangeTickets(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
