package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static lotto.exception.errorcode.InputErrorCode.MISMATCH_PURCHASE_PRICE_AND_LOTTO_COUNT;
import static lotto.fixture.LottoFixture.SECOND;
import static lotto.fixture.PurchaseFixture.네장;
import static lotto.fixture.UserFixture.총_2장_구매_당첨_X_유저;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @DisplayName("로또 개수와 (구매 금액 / 개당 금액)이 일치하지 않으면 예외가 발생한다.")
    @Test
    public void createUserInvalidLottoCount() throws Exception {
        final int lottoCount = 5;
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(SECOND.생성());
        }
        final Purchase purchase = 네장.생성();

        assertThatThrownBy(() -> new User(lottos, purchase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MISMATCH_PURCHASE_PRICE_AND_LOTTO_COUNT.getMessage());
    }

    @DisplayName("로또 개수를 반환한다.")
    @Test
    public void getLottoCount() throws Exception {
        final User user = 총_2장_구매_당첨_X_유저.생성();
        final int expect = 2;
        final int actual = user.getPurchaseCount();
        assertThat(actual).isEqualTo(expect);
    }
}