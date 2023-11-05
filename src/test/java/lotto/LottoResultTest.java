package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("번호가 3개 일치할 경우")
    @Test
    public void correspondThreeNumber() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto issuedlotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        lottoResult = new LottoResult(new WinningNumber(winningLotto, 7), Arrays.asList(issuedlotto));

        // when
        long result = lottoResult.matchingCount(issuedlotto);

        // then
        int expected = 3;
        assertEquals(expected, result);
    }

    @DisplayName("번호가 4개 일치할 경우")
    @Test
    public void correspondFourNumber() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto issuedlotto = new Lotto(Arrays.asList(3, 4, 5, 6, 10, 11));
        lottoResult = new LottoResult(new WinningNumber(winningLotto, 7), Arrays.asList(issuedlotto));

        // when
        long result = lottoResult.matchingCount(issuedlotto);

        // then
        int expected = 4;
        assertEquals(expected, result);
    }

    @DisplayName("번호가 5개 일치할 경우")
    @Test
    public void correspondFiveNumber() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto issuedlotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 11));
        lottoResult = new LottoResult(new WinningNumber(winningLotto, 7), Arrays.asList(issuedlotto));

        // when
        long result = lottoResult.matchingCount(issuedlotto);

        // then
        int expected = 5;
        assertEquals(expected, result);
    }

    @DisplayName("번호가 6개 일치할 경우")
    @Test
    public void correspondSixNumber() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto issuedlotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoResult = new LottoResult(new WinningNumber(winningLotto, 7), Arrays.asList(issuedlotto));

        // when
        long result = lottoResult.matchingCount(issuedlotto);

        // then
        int expected = 6;
        assertEquals(expected, result);
    }

    @DisplayName("3개 일치 1개일 경우 62.5 수익률을 반환")
    @Test
    public void returnCalculation() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto issuedlotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoResult = new LottoResult(new WinningNumber(winningLotto, 7), Arrays.asList(issuedlotto));
        Map<String, Long> result = new HashMap<>();
        result.put("1", 0L);
        result.put("2", 0L);
        result.put("3", 0L);
        result.put("4", 0L);
        result.put("5", 1L);

        // when
        Float price = lottoResult.returnCalculation(result, 8000L);

        // then
        Float expected = 62.5f;
        assertEquals(expected, price);
    }
}
