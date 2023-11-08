package lotto.model;

import static lotto.model.enums.Rank.FIFTH;
import static lotto.model.enums.Rank.FIRST;
import static lotto.model.enums.Rank.FOURTH;
import static lotto.model.enums.Rank.OTHER;
import static lotto.model.enums.Rank.SECOND;
import static lotto.model.enums.Rank.THIRD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.enums.Rank;
import lotto.model.exceptions.DuplicatedNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinLottoTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("우승 번호와 중복된 숫자 입력 예외 발생")
    void duplicateNumberInput(int input) {
        assertThatThrownBy(() -> new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(input)))
                .isInstanceOf(DuplicatedNumberException.class);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("LottoParameter")
    @DisplayName("로또 랭크 계산 테스트")
    void calculateLottoRank(String testName, List<Integer> input, Rank rank) {
        WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        Rank result = winLotto.calculateLottoRank(new Lotto(input));
        assertThat(result).isEqualTo(rank);
    }

    private static Stream<Arguments> LottoParameter() {
        return Stream.of(
                Arguments.of("OTHER 0개", List.of(7, 8, 9, 10, 11, 12), OTHER),
                Arguments.of("OTHER 1개", List.of(1, 7, 8, 9, 10, 11), OTHER),
                Arguments.of("OTHER 2개", List.of(1, 2, 7, 8, 9, 10), OTHER),
                Arguments.of("FIFTH 3개", List.of(1, 2, 3, 7, 8, 9), FIFTH),
                Arguments.of("FOURTH 4개", List.of(1, 2, 3, 4, 7, 8), FOURTH),
                Arguments.of("THIRD 5개", List.of(1, 2, 3, 4, 5, 10), THIRD),
                Arguments.of("SECOND 5개 + 보너스 번호", List.of(1, 2, 3, 4, 5, 7), SECOND),
                Arguments.of("FIRST 6개", List.of(1, 2, 3, 4, 5, 6), FIRST)
        );
    }
}