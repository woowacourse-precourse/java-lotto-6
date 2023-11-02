package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssuerTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(ints = {1, 5, 100})
    void checkBuy(Integer lottoTicket) {
        LottoIssuer lottoIssuer = new LottoIssuer(lottoTicket, new LottoGenerator());
        assertThat(lottoIssuer.issueLotto().size()).isEqualTo(lottoTicket);
    }
}