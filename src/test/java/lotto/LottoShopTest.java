package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoShop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    LottoShop lottoShop;

    @BeforeEach
    void init() {
        lottoShop = new LottoShop();
    }

    @DisplayName("구매 금액만큼 로또를 생성한다.")
    @Test
    void createLottoByOverSize() {
        List<Lotto> lottos = lottoShop.buy(8000);
        assertThat(lottos.size()).isEqualTo(8);
        assertThat(lottos.get(0).getNumbers().size()).isEqualTo(6);
    }
}
