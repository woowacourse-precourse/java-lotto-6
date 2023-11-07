package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SellerTest {
    @DisplayName("정상적인 로또 판매 테스트")
    @Test
    void sellLotto() {
        Seller seller = new Seller();
        List<Lotto> lottos = seller.sellLotto(5000);

        Assertions.assertThat(lottos.size())
                        .isEqualTo(5);
        Assertions.assertThat(seller.sellLotto(3000).size())
                .isEqualTo(3);
        Assertions.assertThat(seller.sellLotto(1000).size())
                .isEqualTo(1);
    }

    @DisplayName("정확한 금액으로 나누어 떨어지지 않는 경우 예외 발생")
    @Test
    void sellLotto_ThrowIllegalArgumentException_IfNotDivided() {
        Seller seller = new Seller();
        assertThatThrownBy(() -> seller.sellLotto(4500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}