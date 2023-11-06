package lotto;

import Model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @DisplayName("금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createUserWithNonDividedByThousand() {
        assertThatThrownBy(() -> new User("12500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
