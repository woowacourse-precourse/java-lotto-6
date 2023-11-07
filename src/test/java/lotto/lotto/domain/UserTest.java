package lotto.lotto.domain;

import lotto.domain.Draw;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @DisplayName("음수 입력값으로 유저를 생성할 수 없다.")
    @Test
    void createUserByNegativeMoney() {
        assertThatThrownBy(() -> new User(-123123))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위로 유저를 생성해야 한다.")
    @Test
    void createUserByNonDivisible() {
        assertThatThrownBy(() -> new User(1023))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("1000원 미만의 금액으로 유저를 생성할 수 없다.")
    @Test
    void createUserByLessThanMinimumMoney() {
        assertThatThrownBy(() -> new User(123))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 입력에서는 로또를 구매할 수 있어야 한다.")
    @Test
    void userBuyLotto() {
        User user = new User(10000);

        Assertions.assertDoesNotThrow(user::buyLotto);
    }

    @DisplayName("추첨 정보가 없다면 예외를 반환한다.")
    @Test
    void cannotDoDrawWithoutDraw() {
        User user = new User(10000);
        user.buyLotto();

        assertThatThrownBy(() -> user.doDraw(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 구매하지 않았다면 예외를 발생한다.")
    @Test
    void doDrawWithoutLotto() {
        User user = new User(10000);
        Draw draw = new Draw(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThatThrownBy(() -> user.doDraw(draw))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추첨을 정상적으로 진행한다.")
    @Test
    void doDraw() {
        User user = new User(10000);
        user.buyLotto();
        Draw draw = new Draw(List.of(1, 2, 3, 4, 5, 6), 7);

        Assertions.assertDoesNotThrow(() -> user.doDraw(draw));
    }
}