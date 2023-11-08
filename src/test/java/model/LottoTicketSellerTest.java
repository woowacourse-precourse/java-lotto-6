package model;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketSellerTest {
    private static LottoTicketSeller lottoTicketSeller;
    private static int moneyExample= 15000;
    @BeforeAll
    static void beforeAll() {
        lottoTicketSeller = new LottoTicketSeller(moneyExample);
    }

    @DisplayName("주어진 금액으로 살 수 있는 로또 장수 반환 테스트")
    @Test
    void receiveLottoticketsTest() {
        assertThat(lottoTicketSeller.receiveLottotickets()).isEqualTo(15);
    }
}
