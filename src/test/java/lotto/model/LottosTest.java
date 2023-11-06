package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @DisplayName("로또 번호 여러개 생성하면 오름차순으로 정렬해서 저장한다.")
    @Test
    void generateLottosTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = new Lottos();
                    lottos.generate(3);
                    assertThat(lottos.toString()).isEqualTo(
                            "[3, 21, 32, 43, 44, 45]\n" +
                                    "[1, 2, 3, 4, 5, 6]\n" +
                                    "[1, 2, 3, 34, 44, 45]\n"
                    );
                },
                List.of(45, 44, 43, 32, 21, 3),
                List.of(6, 5, 4, 3, 2, 1),
                List.of(34, 44, 45, 1, 2, 3)
        );
    }

    @DisplayName("로또 번호들을 winningLotto와 연산하면 각 하나씩 당첨된다.")
    @Test
    void calculateLottoGradesTest() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        winningLotto.setBonusNumber(7);
        Lottos lottos = new Lottos();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottos.generate(6);
                    Map<LottoGrade, Integer> grades = lottos.calculateLottoGrades(winningLotto);
                    assertThat(grades.getOrDefault(LottoGrade.NO_GRADE, 0)).isEqualTo(1);
                    assertThat(grades.getOrDefault(LottoGrade.THREE_MATCH, 0)).isEqualTo(1);
                    assertThat(grades.getOrDefault(LottoGrade.FOUR_MATCH, 0)).isEqualTo(1);
                    assertThat(grades.getOrDefault(LottoGrade.FIVE_AND_BONUS_MATCH, 0)).isEqualTo(1);
                    assertThat(grades.getOrDefault(LottoGrade.FIVE_MATCH, 0)).isEqualTo(1);
                    assertThat(grades.getOrDefault(LottoGrade.SIX_MATCH, 0)).isEqualTo(1);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 9, 10),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 7, 10, 11, 12)
        );


    }
}
