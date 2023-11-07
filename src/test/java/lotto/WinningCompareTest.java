package lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.model.Bonus;
import lotto.domain.model.CorrectResult;
import lotto.domain.model.Lotto;
import lotto.domain.model.Winning;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCompareTest {

    private static Winning winning;

    @BeforeAll
    static void beforeAll() {
        Lotto main = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        winning = new Winning(main, bonus);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("발행된 로또 번호가 당첨 번호+보너스 번호와 얼마나 일치하는지 검사한다.")
    void countSameNumberTest(List<Integer> lottoNumbers, int sameCount, boolean existBonus) {
        Lotto lotto = new Lotto(lottoNumbers);
        CorrectResult correctResult = winning.countSameNumber(lotto);

        assertThat(correctResult).usingRecursiveComparison()
                .isEqualTo(new CorrectResult(sameCount, existBonus));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, false), //6개+0개 일치
                Arguments.of(List.of(7, 5, 4, 3, 2, 1), 5, true), //5개+1개 일치
                Arguments.of(List.of(4, 3, 1, 2, 8, 5), 5, false), //5개+0개 일치
                Arguments.of(List.of(6, 5, 4, 2, 7, 45), 4, true), //4개+1개 일치
                Arguments.of(List.of(2, 3, 4, 1, 35, 45), 4, false), //4개+0개 일치
                Arguments.of(List.of(6, 5, 4, 13, 14, 7), 3, true), //3개+1개 일치
                Arguments.of(List.of(2, 1, 3, 15, 16, 17), 3, false), //3개+0개 일치
                Arguments.of(List.of(4, 5, 11, 12, 13, 7), 2, true), //2개+1개 일치
                Arguments.of(List.of(11, 12, 15, 16, 3, 4), 2, false), //2개+0개 일치
                Arguments.of(List.of(6, 7, 8, 9, 10, 11), 1, true), //1개+1개 일치
                Arguments.of(List.of(22, 23, 26, 28, 4, 11), 1, false), //1개+0개 일치
                Arguments.of(List.of(23, 24, 25, 26, 27, 7), 0, true), //0개+1개 일치
                Arguments.of(List.of(23, 24, 25, 26, 27, 28), 0, false) //0개+0개 일치
        );
    }
}
