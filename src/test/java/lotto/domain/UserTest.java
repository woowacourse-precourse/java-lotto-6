package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("구입 금액이 1000원보다 작을 때 오류 발생")
    @Test
    void purchaseAmountLessThanCorrectRange() {
        assertThatThrownBy(() -> new User(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 10억원보다 클 때 오류 발생")
    @Test
    void purchaseAmountOverThanCorrectRange() {
        assertThatThrownBy(() -> new User(2100000000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 때 오류 발생")
    @Test
    void purchaseAmountIsNotThousandUnit_1(){
        assertThatThrownBy(() -> new User(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 때 오류 발생")
    @Test
    void purchaseAmountIsNotThousandUnit_2(){
        assertThatThrownBy(() -> new User(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}