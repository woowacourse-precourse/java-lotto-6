package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.GradeConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setup() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Lotto> playerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(2, 3, 4, 5, 6, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 7, 8)), // 4등
                new Lotto(List.of(1, 2, 3, 7, 8, 9)), // 5등
                new Lotto(List.of(1, 7, 8, 9, 10, 11)) // NOTHING
        );

        referee = new Referee(playerLottos, winningLotto, bonusNumber);
    }

    @DisplayName("1등부터 5등까지 그리고 NOTHING까지 모든 등급을 갖고있다.")
    @Test
    void 등수_채점_성공_테스트() {
        List<GradeConstant> expectedResult = List.of(
                GradeConstant.FIRST,
                GradeConstant.SECOND,
                GradeConstant.THIRD,
                GradeConstant.FOURTH,
                GradeConstant.FIFTH,
                GradeConstant.NOTHING
        );

        List<GradeConstant> actualResult = referee.getGrades();

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}