package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssuerTest {

    private static final Integer wantedNumberOfTickets = 4;
    @BeforeEach
    void setUp() {
        LottoIssuer lottoIssuer = new LottoIssuer(new RandomLottoNumberGenerator());
    }

    @DisplayName("로또를 발행 개수만큼 발행해준다.")
    @Test
    void issue() {
        //given
        LottoIssuer lottoIssuer = new LottoIssuer(new RandomLottoNumberGenerator());

        //when
        LottoTickets issuedLottos = lottoIssuer.issue(wantedNumberOfTickets);

        //then
        assertThat(issuedLottos.getLottos().size())
                .isEqualTo(wantedNumberOfTickets);
    }
}