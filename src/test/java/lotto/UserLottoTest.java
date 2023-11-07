package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class UserLottoTest {

    @DisplayName("구입 금액이 음수일 때 예외")
    @Test
    void checkNegativeMoney() {
        assertThatThrownBy(() -> new UserLotto(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000 단위가 아닐 때 예외")
    @Test
    void checkMoneyUnit() {
        assertThatThrownBy(() -> new UserLotto(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 따라 적절한 개수 구매")
    @Test
    void checkLottoCount() {
        //given
        int money = 3000;
        int lottoCount = 3;

        //when
        UserLotto userLotto = new UserLotto(money);

        //then
        Assertions.assertThat(userLotto.getLottoCount()).isEqualTo(lottoCount);
    }

    @DisplayName("구입 금액에 따라 적절한 개수 구매")
    @Test
    void checkLottoBundle() {
        //given
        int money = 3000;
        int lottoCount = 3;

        //when
        UserLotto userLotto = new UserLotto(money);

        //then
        List<Lotto> lottoBundle = userLotto.getLottoBundle();
        Assertions.assertThat(lottoBundle.size()).isEqualTo(lottoCount);
    }
}
