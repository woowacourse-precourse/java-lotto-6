package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class PercentTest {
    @DisplayName("퍼센트 객체가 정상 생성되는지 테스트")
    @Test
    void createPercentInNormalValue() {
        // given
        LottoTicketMoney lottoTicketMoney = new LottoTicketMoney(10000);
        PriceMoney priceMoney = new PriceMoney(5000);

        // when, then
        assertThatCode(() -> new Percent(lottoTicketMoney, priceMoney)).doesNotThrowAnyException();
    }
}
