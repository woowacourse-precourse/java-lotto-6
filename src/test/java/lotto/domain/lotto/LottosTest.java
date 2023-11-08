package lotto.domain.lotto;

import lotto.domain.mock.MockNumberPicker;
import lotto.domain.random.LottoNumberPicker;
import lotto.domain.result.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {2000, 40000, 1000000})
    void 구매개수에_따른_로또를_생성한다(int amount) {
        // Given
        LottoAmount lottoAmount = new LottoAmount(amount);

        // When
        Lottos lottos = Lottos.generateByAmount(lottoAmount, new LottoNumberPicker());

        // Then
        assertNotNull(lottos);
    }

    @Test
    void 우승번호가_주어진_경우_결과_리스트를_반환한다() {
        // Given
        MockNumberPicker mockNumberPicker = MockNumberPicker.setNumbers(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8));
        Lottos lottos = Lottos.generateByAmount(new LottoAmount(3000), mockNumberPicker);
        WinningLotto winningLotto = WinningLottoGenerator.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // When
        List<Result> results = lottos.getResults(winningLotto);

        // Then
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, results.size()),
                () -> Assertions.assertTrue(results.contains(Result.FIRST)),
                () -> Assertions.assertTrue(results.contains(Result.SECOND)),
                () -> Assertions.assertTrue(results.contains(Result.THIRD))
        );
    }
}