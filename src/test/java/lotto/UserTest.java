package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @DisplayName("구입 금액 숫자로 가져오기")
    @Test
    void getMoneyNumber() {
        User user = new User();
        int actualNumber = user.getMoneyNumber("11000");
        int expectedNumber = 11000;

        assertThat(expectedNumber).isEqualTo(actualNumber);
    }

    @DisplayName("구입 금액이 정수가 아닌 경우")
    @Test
    void getMoneyByNotNumber() {
        User user = new User();
        assertThatThrownBy(() -> user.getMoneyNumber("money"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액 1,000원 단위가 아닌 경우")
    @Test
    void getMoneyNumberByInvalidUnit() {
        User user = new User();
        assertThatThrownBy(() -> user.getMoneyNumber("11110"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 구하기")
    @Test
    void getWinningNumbers() {
        User user = new User();
        List<Integer> actualNumbers = user.getWinningNumbers("1,2,3,4,5,6");
        List<Integer> expectedNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }

    @DisplayName("당첨 번호에 정수가 아닌 값이 포함된 경우")
    @Test
    void getWinningNumbersByInvalidType() {
        User user = new User();
        assertThatThrownBy(() -> user.getWinningNumbers("1,a,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개 미만인 경우")
    @Test
    void getWinningNumbersByLackCount() {
        User user = new User();
        assertThatThrownBy(() -> user.getWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개 초과인 경우")
    @Test
    void getWinningNumbersByOverCount() {
        User user = new User();
        assertThatThrownBy(() -> user.getWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위가 아닌 숫자를 포함하는 경우")
    @Test
    void getWinningNumbersByInvalidRange() {
        User user = new User();
        assertThatThrownBy(() -> user.getWinningNumbers("1,2,3,4,5,100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 번호가 있는 경우")
    @Test
    void getWinningNumbersByDuplication() {
        User user = new User();
        assertThatThrownBy(() -> user.getWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 구하기")
    @Test
    void getBonusNumber() {
        User user = new User();
        int actualBonus = user.getBonusNumber("42",
                List.of(1, 2, 3, 4, 5, 6)
        );
        int expectedBonus = 42;

        assertThat(expectedBonus).isEqualTo(actualBonus);
    }

    @DisplayName("정수가 아닌 값인 경우")
    @Test
    void getBonusNumberByInvalidType() {
        User user = new User();
        assertThatThrownBy(() -> user.getBonusNumber(
                "7,8", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 범위가 아닌 경우")
    @Test
    void getBonusNumberByInvalidRange() {
        User user = new User();
        assertThatThrownBy(() -> user.getBonusNumber(
                "100", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복된 번호인 경우")
    @Test
    void getBonusNumberByDuplication() {
        User user = new User();
        assertThatThrownBy(() -> user.getBonusNumber(
                "1", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }
}