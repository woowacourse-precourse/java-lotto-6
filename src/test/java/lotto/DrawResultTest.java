package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawResultTest {

    @DisplayName("당첨 번호의 요소 값이 범위를 벗어난 경우 예외를 발생시킨다.")
    @Test
    void createDrawResultWithOutrangedWinningNumbers() {
        assertThatThrownBy(() -> {
            DrawResult drawResult = new DrawResult
                    .Builder()
                    .winningNumbers(List.of(0, 1, 2, 3, 4, 5))
                    .bonusNumber(6)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            DrawResult drawResult = new DrawResult
                    .Builder()
                    .winningNumbers(List.of(1, 2, 3, 4, 5, 46))
                    .bonusNumber(6)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 요소 중 중복이 있는 경우 예외를 발생시킨다.")
    @Test
    void createDrawResultWithDuplicatedWinningNumbers() {
        assertThatThrownBy(() -> {
            DrawResult drawResult = new DrawResult
                    .Builder()
                    .winningNumbers(List.of(1,2,3,4,5,5))
                    .bonusNumber(6)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 길이가 6을 초과하는 경우 예외를 발생시칸다.")
    @Test
    void createDrawResultWithTooLargeWinningNumbers() {
        assertThatThrownBy(() -> {
            DrawResult drawResult = new DrawResult
                    .Builder()
                    .winningNumbers(List.of(1,2,3,4,5,6,7))
                    .bonusNumber(6)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 길이가 6 미만인 경우 예외를 발생시칸다.")
    @Test
    void createDrawResultWithTooSmallWinningNumbers() {
        assertThatThrownBy(() -> {
            DrawResult drawResult = new DrawResult
                    .Builder()
                    .winningNumbers(List.of(1,2,3))
                    .bonusNumber(6)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 값이 범위를 벗어난 경우 예외를 발생시킨다.")
    @Test
    void createDrawResultWithOutrangedBonusNumber() {
        assertThatThrownBy(() -> {
            DrawResult drawResult = new DrawResult
                    .Builder()
                    .winningNumbers(List.of(1,2,3,4,5,6))
                    .bonusNumber(0)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            DrawResult drawResult = new DrawResult
                    .Builder()
                    .winningNumbers(List.of(1,2,3,4,5,6))
                    .bonusNumber(46)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외를 발생시킨다.")
    @Test
    void createDrawResultWithDuplicatedBonusNumber() {
        assertThatThrownBy(() -> {
            DrawResult drawResult = new DrawResult
                    .Builder()
                    .winningNumbers(List.of(1,2,3,4,5,6))
                    .bonusNumber(6)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 등수 확인 기능 테스트")
    @Test
    void checkTest() {
        DrawResult drawResult = new DrawResult.Builder()
                .winningNumbers(List.of(1,2,3,4,5,6))
                .bonusNumber(7)
                .build();

        Lotto first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto third = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto fourth = new Lotto(List.of(1, 2, 3, 4, 20, 30));
        Lotto fifth = new Lotto(List.of(1, 2, 3, 10, 20, 30));
        Lotto lose = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        Assertions.assertEquals(Prize.FIRST, drawResult.check(first));
        Assertions.assertEquals(Prize.SECOND, drawResult.check(second));
        Assertions.assertEquals(Prize.THIRD, drawResult.check(third));
        Assertions.assertEquals(Prize.FOURTH, drawResult.check(fourth));
        Assertions.assertEquals(Prize.FIFTH, drawResult.check(fifth));
        Assertions.assertEquals(Prize.LOSE, drawResult.check(lose));
    }
}