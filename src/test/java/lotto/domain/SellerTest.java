package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SellerTest {
    @Test
    void 금액_입력_시_로또_개수_리턴() {
        assertThat(Seller.numberOfLotto(12000)).isEqualTo(12);
    }

    @Test
    void 로또_개수_입력_시_로또_객체의_리스트_리턴() {
        Integer numberOfLotto = 8;

        assertThat(Seller.makeLottos(numberOfLotto).size()).isEqualTo(8);
    }
}
