package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoNumbersTest {
    @Test
    @DisplayName("랜덤 로또 번호 생성 테스트")
    void testRandomLottoNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    RandomLottoNumbers randomLotto = RandomLottoNumbers.of(8);
                    assertThat(randomLotto.toString()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("비교 후 결과 반환 확인")
    @Test
    void testCheckResult() {
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;

        Map<Integer, Integer> result = new HashMap<>();
        result.put(0, 1);
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);

        assertRandomUniqueNumbersInRangeTest (
                () -> {
                    RandomLottoNumbers randomLotto = RandomLottoNumbers.of(8);
                    Map<Integer, Integer> randomResult = randomLotto.checkResult(answerLotto, bonus);

                    assertThat(randomResult).isEqualTo(result);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
}