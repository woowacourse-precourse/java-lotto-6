package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
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
}
