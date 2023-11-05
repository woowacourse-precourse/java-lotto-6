package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.model.Lotto;
import lotto.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class UserTest {

    @DisplayName("구입 금액만큼 로또를 발행한다.")
    @Test
    void 구입_금액_만큼_로또_발행() {
        // given
        int amount = 8000;
        int lottoPrice = 1000;
        User user = User.from(amount);

        // when
        user.purchaseLottos();
        List<Lotto> purchasedLottos = user.getPurchasedLottos();

        // then
        assertEquals(amount/lottoPrice, purchasedLottos.size());
    }
}
