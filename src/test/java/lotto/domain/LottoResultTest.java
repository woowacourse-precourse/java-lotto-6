package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("로또 결과 테스트")
    @Test
    void calculateResultTest() {
        Lotto winningLotto = new Lotto(Arrays.asList(13, 15, 19, 22, 5, 30));

        List<List<Integer>> lottoPapers = Arrays.asList(
                Arrays.asList(13, 22, 30, 4, 15, 6),
                Arrays.asList(13, 22, 20, 15, 9, 30),
                Arrays.asList(13, 22, 30, 5, 15, 20)
        );

        LottoResult lottoResult = new LottoResult();
        Map<Result, Integer> resultCounter = lottoResult.calculateResult(winningLotto, lottoPapers, 20);

        assertEquals(2, resultCounter.get(Result.FOUR_SAME));
        assertEquals(1, resultCounter.get(Result.FIVE_AND_BONUS_SAME));
    }
}
