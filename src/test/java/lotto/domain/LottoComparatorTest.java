package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoComparatorTest {
    private static Stream<Lottos> provideLotto() {
        return Stream.of(
                new Lottos(Arrays.asList(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                        new Lotto(List.of(1, 2, 3, 4, 12, 14)),
                        new Lotto(List.of(1, 2, 3, 11, 16, 18)),
                        new Lotto(List.of(1, 2, 11, 22, 31, 14)),
                        new Lotto(List.of(1, 17, 21, 15, 25, 26))
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("provideLotto")
    void compareLottoAndWinningLotto_정상적으로_LottosResult_반환한다(Lottos lottos) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoComparator lottoComparator = new LottoComparator(lottos, winningLotto);
        LottosResult lottosResult = lottoComparator.compareLottoAndWinningLotto();

        assertEquals(1, lottosResult.get(Winner.FRIST));
        assertEquals(2, lottosResult.get(Winner.SECOND));
        assertEquals(0, lottosResult.get(Winner.THIRD));
        assertEquals(2, lottosResult.get(Winner.FOURTH));
        assertEquals(1, lottosResult.get(Winner.FIFTH));

    }


}