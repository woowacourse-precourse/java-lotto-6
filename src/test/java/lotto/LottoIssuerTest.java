package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIssuerTest extends LottoIssuer {

    @Test
    void 로또_자동_발행_테스트() {

        //given
        int lottoNum = 14000;

        //when
        List<Lotto> lottos = issueLottos(lottoNum);

        //then
        assertThat(lottos.size()).isEqualTo(14);
    }
}
