package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoShop;
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
    void buyLottoWithMoney() {
        List<Lotto> lottos = lottoShop.buy(8000);
        assertThat(lottos.size()).isEqualTo(8);
    }

    @DisplayName("하나의 로또는 6만큼의 길이를 가진다.")
    @Test
    void lottoSizeMustBeSix() {
        List<Lotto> lottos = lottoShop.buy(2000);
        assertThat(lottos.get(0).getNumbers().size()).isEqualTo(6);
        assertThat(lottos.get(1).getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또는 오름차순으로 정렬되어 있어야 한다.")
    @Test
    void lottoMustBeAscending() {
        List<Lotto> lottos = lottoShop.buy(1000);
        assertThat(lottos.get(0).getNumbers())
                .isEqualTo(lottos.get(0).getNumbers().stream().sorted().toList());
    }
}
