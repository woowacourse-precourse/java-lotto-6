package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.ApplicationConfig;
import lotto.model.lotto.Lottos;
import lotto.model.trade.LottoSeller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoSellerTest {
    ApplicationConfig applicationConfig;
    LottoSeller seller;

    @BeforeEach
    void setSeller() {
        applicationConfig = new ApplicationConfig();
        seller = applicationConfig.lottoSeller();
    }

    @DisplayName("구입한 개수만큼 로또를 발행해야 한다.")
    @Test
    void createLottoByCountOfLotto() {
        //given
        int countOfLotto = 10;

        //when
        Lottos lottos = seller.sell(countOfLotto);

        //then
        assertThat(lottos.size()).isEqualTo(countOfLotto);
    }
}
