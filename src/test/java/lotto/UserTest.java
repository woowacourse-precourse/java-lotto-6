package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserTest {

    @Test
    void userPay() {
        User user = new User();
        int money = user.pay("2000");

        Assertions.assertThat(money).isEqualTo(2000);
    }

    @Test
    void notPer1000Pay() {
        User user = new User();
        Assertions.assertThatThrownBy(() -> user.pay("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void notNumberPay() {
        User user = new User();
        Assertions.assertThatThrownBy(() -> user.pay("money"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputWinningNumber() {
        User user = new User();
        List<Integer> winningNumbers = user.inputWinningNumbers("1,2,3,4,5,6");

        Assertions.assertThat(winningNumbers.size()).isEqualTo(6);
    }

    @Test
    void inputOverflowWinningNumber() {
        User user = new User();

        Assertions.assertThatThrownBy(() -> user.inputWinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputOversizeWinningNumber() {
        User user = new User();

        Assertions.assertThatThrownBy(() -> user.inputWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputStringWinningNumber() {
        User user = new User();

        Assertions.assertThatThrownBy(() -> user.inputWinningNumbers("winning numbers"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputSameWinningNumber() {
        User user = new User();

        Assertions.assertThatThrownBy(() -> user.inputWinningNumbers("1,1,1,1,1,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputBonusNumber() {
        User user = new User();
        int bonusNumber = user.inputBonusNumber("4");

        Assertions.assertThat(bonusNumber).isEqualTo(4);
    }

    @Test
    void inputOverflowBonusNumber() {
        User user = new User();

        Assertions.assertThatThrownBy(() -> user.inputBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputStringBonusNumber() {
        User user = new User();

        Assertions.assertThatThrownBy(() -> user.inputBonusNumber("bonus"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
