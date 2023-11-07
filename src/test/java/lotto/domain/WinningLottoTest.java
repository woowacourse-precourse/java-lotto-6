package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {
    private static Stream<Arguments> provideLottoAndResult() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoScore(6, false)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new LottoScore(5, true)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new LottoScore(5, false)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                        new LottoScore(4, false))
        );
    }

    @Test
    void Null값이_들어오면_IAE() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(null, 1));
    }

    @Test
    void BonusNumber가_1_45_범위에_벗어나면_IAE() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0));
    }

    @Test
    void BonusNumber가_Lotto에_포함되면_IAE() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 1));
    }

    @ParameterizedTest
    @MethodSource("provideLottoAndResult")
    void calculateLottoScore_결과가_정상적으로_수행되는지(Lotto lotto, LottoScore lottoScore) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoScore result = winningLotto.calculateLottoScore(lotto);
        assertEquals(lottoScore, result);
    }
}