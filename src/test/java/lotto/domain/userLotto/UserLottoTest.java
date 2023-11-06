package lotto.domain.userLotto;

import lotto.domain.LottoCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottoTest {

    @Test
    @DisplayName("로또 구입 금액을 로또 하나의 금액으로 나눈 값이 사용자의 로또 개수")
    void When_DivisibleByLottoPrice_Expect_UserLottoSizeIsPurchasePriceDividedByLottoPrice() {
        // given
        int purchasePrice = 3000;

        // when
        UserLotto userLotto = new UserLotto(purchasePrice);

        // then
        Assertions.assertThat(userLotto.getLottos().size()).isEqualTo(purchasePrice / LottoCondition.PRICE.getValue());
    }
}
