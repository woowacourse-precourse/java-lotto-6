package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottosTest {

    private static Lottos lottos;

    @BeforeAll
    static void setUp() {
        Lotto one = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto two = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto three = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos = new Lottos(List.of(one, two, three));
    }

    @ParameterizedTest(name = "당첨번호 : {0}, 보너스 번호 : {1}")
    @MethodSource("generateDuplicateWinningNumbers")
    @DisplayName("당첨 결과에 따라 로또 결과 리스트를 반환한다.")
    void 로또_결과_리스트_반환_테스트(List<Integer> winning, int bonus, List<LottoResults> expected) {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(winning, bonus);

        //when
        List<LottoResults> actual = lottos.calculateAllOfLottoResult(winningNumbers);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> generateDuplicateWinningNumbers() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(LottoResults.FIRST, LottoResults.FIRST, LottoResults.FIRST)
                ),
                Arguments.of(
                        List.of(1, 2, 3, 14, 15, 16),
                        7,
                        List.of(LottoResults.FIFTH, LottoResults.FIFTH, LottoResults.FIFTH)
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 15, 16),
                        7,
                        List.of(LottoResults.FOURTH, LottoResults.FOURTH, LottoResults.FOURTH)
                ),
                Arguments.of(
                        List.of(11, 12, 13, 14, 15, 16),
                        7,
                        List.of(LottoResults.FAIL, LottoResults.FAIL, LottoResults.FAIL)
                )
        );
    }
}
