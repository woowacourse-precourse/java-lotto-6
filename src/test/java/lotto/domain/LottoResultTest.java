package lotto.domain;

import static lotto.domain.LottoCriteria.FIFTH_PLACE;
import static lotto.domain.LottoCriteria.FIRST_PLACE;
import static lotto.domain.LottoCriteria.FOURTH_PLACE;
import static lotto.domain.LottoCriteria.THIRD_PLACE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    Lotto winningLotto;
    Bonus bonus;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonus = new Bonus(7);
    }

    @DisplayName("번호가 3개 일치할 경우")
    @Test
    public void correspondThreeNumber() {
        // given
        Lotto issuedlotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        LottoResult lottoResult = new LottoResult(
                new WinningNumber(winningLotto, bonus), Arrays.asList(issuedlotto));
        Map<LottoCriteria, Long> result = lottoResult.getRankingResult();

        // then
        int expected = 1;
        assertEquals(expected, result.get(FIFTH_PLACE));
    }

    @DisplayName("번호가 4개 일치할 경우")
    @Test
    public void correspondFourNumber() {
        // given
        Lotto issuedlotto = new Lotto(Arrays.asList(3, 4, 5, 6, 10, 11));
        LottoResult lottoResult = new LottoResult(new WinningNumber(winningLotto, bonus), Arrays.asList(issuedlotto));

        // when
        Map<LottoCriteria, Long> result = lottoResult.getRankingResult();

        // then
        int expected = 1;
        assertEquals(expected, result.get(FOURTH_PLACE));
    }

    @DisplayName("번호가 5개 일치할 경우")
    @Test
    public void correspondFiveNumber() {
        // given
        Lotto issuedlotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 11));
        LottoResult lottoResult = new LottoResult(new WinningNumber(winningLotto, bonus), Arrays.asList(issuedlotto));

        // when
        Map<LottoCriteria, Long> result = lottoResult.getRankingResult();

        // then
        int expected = 1;
        assertEquals(expected, result.get(THIRD_PLACE));
    }

    @DisplayName("번호가 6개 일치할 경우")
    @Test
    public void correspondSixNumber() {
        // given
        Lotto issuedlotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult = new LottoResult(new WinningNumber(winningLotto, bonus), Arrays.asList(issuedlotto));

        // when
        Map<LottoCriteria, Long> result = lottoResult.getRankingResult();

        // then
        int expected = 1;
        assertEquals(expected, result.get(FIRST_PLACE));
    }

    @DisplayName("8개 복권 중 3개 일치 1개일 경우 62.5 수익률을 반환")
    @Test
    public void returnCalculation() {
        // given
        Lotto issuedLotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto issuedLotto2 = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));
        Lotto issuedLotto3 = new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44));
        Lotto issuedLotto4 = new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42));
        Lotto issuedLotto5 = new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45));
        Lotto issuedLotto6 = new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43));
        Lotto issuedLotto7 = new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45));
        Lotto issuedLotto8 = new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45));

        // when
        LottoResult lottoResult = new LottoResult(new WinningNumber(winningLotto, bonus),
                Arrays.asList(issuedLotto1, issuedLotto2, issuedLotto3, issuedLotto4,
                        issuedLotto5, issuedLotto6, issuedLotto7, issuedLotto8));
        Float price = lottoResult.returnCalculation();

        // then
        Float expected = 62.5f;
        assertEquals(expected, price);
    }
}
