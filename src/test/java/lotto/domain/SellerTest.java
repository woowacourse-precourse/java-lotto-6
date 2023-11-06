package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SellerTest {
    @Test
    void 금액_입력_시_로또_개수_리턴() {
        assertThat(Seller.numberOfLotto(12000)).isEqualTo(12);
    }

}
