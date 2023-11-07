package lotto.domain;

import lotto.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @DisplayName("유저 생성자 테스트")
    @Test
    void userConstructorTest() {
        // given
        int buyingPrice = 1000;
        // when
        User user = new User(buyingPrice);
        // then
        assertThat(user.getBuyingPrice()).isEqualTo(buyingPrice);
    }

    @DisplayName("유저 로또 구매 테스트")
    @Test
    public void userSetLottoTest() {
        // given
        int buyingPrice = 3000;
        User user = new User(buyingPrice);
        // when
        user.setLottos(user.getBuyingPrice);
        // then
        assertThat(user.getLottos().size()).isEqualTo(buyingPrice / Constants.LOTTO_PRICE);
    }
}
