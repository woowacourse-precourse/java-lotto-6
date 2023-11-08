package lotto.model.domain;

import lotto.model.constant.LottoConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000, 15000, 20000})
    void userLottoPurchaseTest(int money) {
        //given
        User user = new User();

        //when
        user.enterDraw(money);

        //then
        Assertions.assertThat(user.getMoney()).isEqualTo(money);
        Assertions.assertThat(user.getPurchasedLotto().size())
                .isEqualTo(money / LottoConstant.LOTTO_PRICE.getNumber());
    }

}