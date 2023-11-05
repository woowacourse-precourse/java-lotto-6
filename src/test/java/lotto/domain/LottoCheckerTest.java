package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoCheckerTest {

    @DisplayName("로또 당첨 결과 테스트")
    @Test
    void lottoResult() {
        List<Integer> counts = new ArrayList<>();
        counts.add(3);
        counts.add(4);
        counts.add(3);
        counts.add(5);
        counts.add(10);
        counts.add(6);
        LottoChecker lottoChecker = new LottoChecker();
        List<Integer> result = lottoChecker.lottoResult(counts);
        List<Integer> expectationResult = new ArrayList<>();
        expectationResult.add(1);
        expectationResult.add(1);
        expectationResult.add(1);
        expectationResult.add(1);
        expectationResult.add(2);

        assertEquals(expectationResult, result);
    }
}