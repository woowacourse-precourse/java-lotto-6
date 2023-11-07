package lotto;

import java.util.stream.Stream;
import lotto.domain.constant.Rank;
import lotto.domain.model.CorrectResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static lotto.domain.constant.Rank.FIFTH;
import static lotto.domain.constant.Rank.FIRST;
import static lotto.domain.constant.Rank.FORTH;
import static lotto.domain.constant.Rank.SECOND;
import static lotto.domain.constant.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

public class CorrectResultTest {

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("번호 일치 정보가 적절한 등수와 매칭되는지 검사한다")
    void compareRank(int sameCount, boolean existBonus, Rank rank) {
        CorrectResult correctResult = new CorrectResult(sameCount, existBonus);
        assertThat(correctResult.compare(rank)).isTrue();
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(6, false, FIRST), //6개+0개 일치(1등)
                Arguments.of(5, true, SECOND), //5개+1개 일치(2등)
                Arguments.of(5, false, THIRD), //5개+0개 일치(3등)
                Arguments.of(4, true, FORTH), //4개+1개 일치(4등-case1)
                Arguments.of(4, false, FORTH), //4개+0개 일치(4등-case2)
                Arguments.of(3, true, FIFTH), //3개+1개 일치(5등-case1)
                Arguments.of(3, false, FIFTH) //3개+0개 일치(5등-case2)
        );
    }

}
