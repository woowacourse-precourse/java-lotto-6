package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("User 생성 테스트")
    @Test
    void createUser() {
        User user = new User();
        assertNotNull(user);
    }

    @DisplayName("setUserPurchaseAmount() 테스트")
    @Test
    void setUserPurchaseAmount() {
        User user = new User();
        user.setUserPurchaseAmount(1000);
        assertEquals(1000, user.getUserPurchaseAmount());
    }

    @DisplayName("getUserPurchaseAmount() 테스트")
    @Test
    void getUserPurchaseAmount() {
        User user = new User();
        user.setUserPurchaseAmount(1000);
        assertEquals(1000, user.getUserPurchaseAmount());
    }

    @DisplayName("validateUserPurchaseAmount() 테스트")
    @Test
    void validateUserPurchaseAmount() {
        User user = new User();
        user.setUserPurchaseAmount(1000);
        assertTrue(user.validateUserPurchaseAmount());
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void validateUserPurchaseAmountThatIsNotMultipleOfThousand() {
        User user = new User();
        user.setUserPurchaseAmount(1001);
        // error 메시지에 "[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다."가 포함되어 있는지 확인
        assertThatThrownBy(() -> user.validateUserPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateUserPurchaseAmountThatIsNotNumber() {
        User user = new User();
        // error 메시지에 "[ERROR] 로또 구입 금액은 숫자만 가능합니다."가 포함되어 있는지 확인
        assertThatThrownBy(() -> user.buyLotto("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}