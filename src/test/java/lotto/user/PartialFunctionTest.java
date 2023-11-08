package lotto.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PartialFunctionTest {

    @DisplayName("구입 금액 숫자로 가져오기")
    @Test
    void getMoneyNumber() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        int actualNumber = PARTIAL_FUNCTION.getMoneyNumber("11000");
        int expectedNumber = 11000;

        assertThat(expectedNumber).isEqualTo(actualNumber);
    }

    @DisplayName("구입 금액 숫자로 가져오기")
    @Test
    void getMoneyNumberWithSpace() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        int actualNumber = PARTIAL_FUNCTION.getMoneyNumber("  11000  ");
        int expectedNumber = 11000;

        assertThat(expectedNumber).isEqualTo(actualNumber);
    }

    @DisplayName("구입 금액이 정수가 아닌 경우")
    @Test
    void getMoneyByNotNumber() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getMoneyNumber("money"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 빈 값인 경우")
    @Test
    void getMoneyByNullInput() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getMoneyNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0인 경우")
    @Test
    void getMoneyNumberByZero() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getMoneyNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액 1,000원 단위가 아닌 경우")
    @Test
    void getMoneyNumberByInvalidUnit() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getMoneyNumber("11110"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 구하기")
    @Test
    void getWinningNumbers() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        List<Integer> actualNumbers = PARTIAL_FUNCTION.getWinningNumbers("1,2,3,4,5,6");
        List<Integer> expectedNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }

    @DisplayName("당첨 번호에 빈 값이 포함된 경우")
    @Test
    void getWinningNumbersWithNullValue() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        List<Integer> actualNumbers = PARTIAL_FUNCTION.getWinningNumbers("1,2,,3,4,,5,6");
        List<Integer> expectedNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }

    @DisplayName("당첨 번호에 공백이 포함된 경우")
    @Test
    void getWinningNumbersWithSpace() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        List<Integer> actualNumbers = PARTIAL_FUNCTION.getWinningNumbers("1, 2, 3 , 4, 5, 6");
        List<Integer> expectedNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }

    @DisplayName("당첨 번호 입력이 없는 경우")
    @Test
    void getWinningNumbersByNullInput() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getWinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 정수가 아닌 값이 포함된 경우")
    @Test
    void getWinningNumbersByInvalidType() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getWinningNumbers("1,a,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개 미만인 경우")
    @Test
    void getWinningNumbersByLackCount() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개 초과인 경우")
    @Test
    void getWinningNumbersByOverCount() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위가 아닌 숫자를 포함하는 경우")
    @Test
    void getWinningNumbersByInvalidRange() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getWinningNumbers("1,2,3,4,5,100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 번호가 있는 경우")
    @Test
    void getWinningNumbersByDuplication() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 구하기")
    @Test
    void getBonusNumber() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        int actualBonus = PARTIAL_FUNCTION.getBonusNumber("42",
                List.of(1, 2, 3, 4, 5, 6)
        );
        int expectedBonus = 42;

        assertThat(expectedBonus).isEqualTo(actualBonus);
    }

    @DisplayName("보너스 번호에 공백이 포함된 경우")
    @Test
    void getBonusNumberWithSpace() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        int actualBonus = PARTIAL_FUNCTION.getBonusNumber("  42 ",
                List.of(1, 2, 3, 4, 5, 6)
        );
        int expectedBonus = 42;

        assertThat(expectedBonus).isEqualTo(actualBonus);
    }

    @DisplayName("입력이 없는 경우")
    @Test
    void getBonusNumberByNullInput() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getBonusNumber(
                "", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수가 아닌 값인 경우")
    @Test
    void getBonusNumberByInvalidType() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getBonusNumber(
                "7,8", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 범위가 아닌 경우")
    @Test
    void getBonusNumberByInvalidRange() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getBonusNumber(
                "100", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복된 번호인 경우")
    @Test
    void getBonusNumberByDuplication() {
        PartialFunction PARTIAL_FUNCTION = new PartialFunction();
        assertThatThrownBy(() -> PARTIAL_FUNCTION.getBonusNumber(
                "1", List.of(1, 2, 3, 4, 5, 6)
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }
}