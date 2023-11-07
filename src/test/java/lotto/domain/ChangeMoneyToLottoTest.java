package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeMoneyToLottoTest {

    @Test
    @DisplayName("구입 금액을 로또 티켓 개수로 변경할 때 올바른 개수가 반환되어야 함")
    void changeMoneyToLotto() {
        ChangeMoneyToLotto moneyToLotto = new ChangeMoneyToLotto();
        String purchaseAmount = "7000";
        int expectedLottoCount = 7;
        int lottoCount = moneyToLotto.changeMoneyToLotto(purchaseAmount);
        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }

}
