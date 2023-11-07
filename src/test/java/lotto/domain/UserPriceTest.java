package lotto.domain;

import static lotto.controller.Controller.LOTTO_PRICE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserPriceTest {
    @DisplayName("구매 금액을 생성을 검증하기.")
    @Test
    void userPrice(){
        int price = LOTTO_PRICE * 3;
        UserPrice userPrice = new UserPrice(price);
        assertThat(userPrice.getPrice()).isEqualTo(price);
    }

    @DisplayName(" 구매 금액은 로또 금액 보다 작을 수 없다.")
    @Test
    void userPriceUnderFlow(){
        assertThatThrownBy(
                () -> new UserPrice(LOTTO_PRICE - 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000 으로 나눠 떨어지는지 검증하기.")
    @Test
    void userPriceUnit(){
        assertThatThrownBy(
                () -> new UserPrice(LOTTO_PRICE + 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}