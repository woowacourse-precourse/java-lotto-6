package lotto.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTest {

    @DisplayName("당첨 번호 구하기")
    @Test
    void getWinningNumbers() {
        Winning winning = new Winning();
        List<Integer> actualNumbers = winning.getWinningNumbers("1,2,3,4,5,6");
        List<Integer> expectedNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }

    @DisplayName("당첨 번호에 빈 값이 포함된 경우")
    @Test
    void getWinningNumbersWithNullValue() {
        Winning winning = new Winning();
        List<Integer> actualNumbers = winning.getWinningNumbers("1,2,,3,4,,5,6");
        List<Integer> expectedNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }

    @DisplayName("당첨 번호에 공백이 포함된 경우")
    @Test
    void getWinningNumbersWithSpace() {
        Winning winning = new Winning();
        List<Integer> actualNumbers = winning.getWinningNumbers("1, 2, 3 , 4, 5, 6");
        List<Integer> expectedNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }

    @DisplayName("당첨 번호 입력이 없는 경우")
    @Test
    void getWinningNumbersByNullInput() {
        Winning winning = new Winning();
        assertThatThrownBy(() -> winning.getWinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 정수가 아닌 값이 포함된 경우")
    @Test
    void getWinningNumbersByInvalidType() {
        Winning winning = new Winning();
        assertThatThrownBy(() -> winning.getWinningNumbers("1,a,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개 미만인 경우")
    @Test
    void getWinningNumbersByLackCount() {
        Winning winning = new Winning();
        assertThatThrownBy(() -> winning.getWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개 초과인 경우")
    @Test
    void getWinningNumbersByOverCount() {
        Winning winning = new Winning();
        assertThatThrownBy(() -> winning.getWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위가 아닌 숫자를 포함하는 경우")
    @Test
    void getWinningNumbersByInvalidRange() {
        Winning winning = new Winning();
        assertThatThrownBy(() -> winning.getWinningNumbers("1,2,3,4,5,100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 번호가 있는 경우")
    @Test
    void getWinningNumbersByDuplication() {
        Winning winning = new Winning();
        assertThatThrownBy(() -> winning.getWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}