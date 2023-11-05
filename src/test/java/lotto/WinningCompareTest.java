package lotto;

import lotto.domain.constant.Rank;
import lotto.domain.model.Bonus;
import lotto.domain.model.CorrectResult;
import lotto.domain.model.Lotto;
import lotto.domain.model.Winning;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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
    void compare1(List<Integer> lottoNumbers, int sameCount, boolean existBonus, Rank rank) {
        Lotto lotto = new Lotto(lottoNumbers);
        CorrectResult correctResult = winning.countSameNumber(lotto);

        assertThat(correctResult).usingRecursiveComparison()
                .isEqualTo(new CorrectResult(sameCount, existBonus));

        assertThat(correctResult.compare(rank)).isTrue();

    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, false, Rank.FIRST), //6개+0개 일치(1등)
                Arguments.of(List.of(7, 5, 4, 3, 2, 1), 5, true, Rank.SECOND), //5개+1개 일치(2등)
                Arguments.of(List.of(4, 3, 1, 2, 8, 5), 5, false, Rank.THIRD), //5개+0개 일치(3등)
                Arguments.of(List.of(6, 5, 4, 2, 7, 45), 4, true, Rank.FORTH), //4개+1개 일치(4등-case1)
                Arguments.of(List.of(2, 3, 4, 1, 35, 45), 4, false, Rank.FORTH), //4개+0개 일치(4등-case2)
                Arguments.of(List.of(6, 5, 4, 13, 14, 7), 3, true, Rank.FIFTH), //3개+1개 일치(5등-case1)
                Arguments.of(List.of(2, 1, 3, 15, 16, 17), 3, false, Rank.FIFTH) //3개+0개 일치(5등-case2)
        );
    }
}
