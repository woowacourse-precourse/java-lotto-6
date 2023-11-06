package lotto.domain.lotto.userLotto;

import lotto.domain.lotto.LottoCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserLottoTest {

    @DisplayName("사용자의 로또 개수는 구입 금액을 로또 금액으로 나눈 값이다.")
    @Test
    void createUserLotto() {
        int purchasePrice = 3000;

        UserLotto userLotto = new UserLotto(purchasePrice);

        Assertions.assertThat(userLotto.getLottos().size()).isEqualTo(purchasePrice / LottoCondition.PRICE.getValue());
    }
}
