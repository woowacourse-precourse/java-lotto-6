package lotto.domain.model.generator;

import lotto.domain.model.generator.LottoIssuer;
import lotto.domain.model.generator.RandomLottoNumberGenerator;
import lotto.domain.model.lotto.LottoTickets;
import lotto.domain.model.lotto.PaidAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssuerTest {

    private static final Integer PAID_AMOUNT = 4000;
    private static final Integer PRICE_PER_TICKET = 1000;

    private LottoIssuer lottoIssuer;

    @BeforeEach
    void setUp() {
        lottoIssuer = new LottoIssuer(new RandomLottoNumberGenerator());
    }

    @DisplayName("로또를 발행 개수만큼 발행해준다.")
    @Test
    void issue() {
        //given
        Integer numberOfLottoTickets = PAID_AMOUNT / PRICE_PER_TICKET;

        //when
        LottoTickets issuedLottos = lottoIssuer.issue(new PaidAmount(PAID_AMOUNT));

        //then
        assertThat(issuedLottos.getLottos().size())
                .isEqualTo(numberOfLottoTickets);
    }
}