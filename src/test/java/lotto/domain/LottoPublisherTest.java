package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPublisherTest{

    private LottoPublisher lottoPublisher;

    @BeforeEach
    void init(){
        lottoPublisher = new LottoPublisher();
    }

    @DisplayName("주어진 금액으로 살 수 있는 만큼의 로또를 생성한다.")
    @Test
    void 로또_구매(){
        //given
        int price = 8000;
        Amount amount = new Amount(price);
        int lottoCount = price/1000;

        //when
        Lottos lottos = lottoPublisher.publishLottosByAmount(amount);

        //then
        assertThat(lottos.getSize()).isEqualTo(lottoCount);
    }
}
