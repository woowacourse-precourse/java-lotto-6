package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoSellerTest {
    AutoLottoGenerator generator;
    LottoSeller seller;

    @BeforeEach
    void setSeller() {
        generator = AutoLottoGenerator.getInstance();
        seller = new LottoSeller(generator);
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
