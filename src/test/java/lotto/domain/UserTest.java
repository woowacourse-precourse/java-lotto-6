package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("유저__전체_금액_지불")
    @Test
    void userPayAllTest() {
        int initBudget = 4000;
        User user = User.createByBudget(initBudget);

        user.pay();

        Assertions.assertThat(user.getBudget()).isEqualTo(0);
    }

}