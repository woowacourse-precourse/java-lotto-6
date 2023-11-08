package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottoPriceTest {
    @Test
    @DisplayName("로또 구매 금액 1000원 단위 확인 테스트")
    public void lottoPriceTest() {
        //given
        String buyPrice = "1300";
        //when,then
        Assertions.assertThatThrownBy(() -> new UserLottoPrice(buyPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 단위로 입력해주세요");

    }
}
