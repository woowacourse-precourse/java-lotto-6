package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import lotto.dto.LottoDto;
import lotto.dto.WinningNumbersDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    private WinningNumbersDto winningNumbersDto;
    private LottoResult lottoResult;

    @BeforeEach
    void 셋팅() {
        winningNumbersDto = new WinningNumbersDto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        lottoResult = new LottoResult();
    }

    @Test
    @Order(1)
    @DisplayName("SIX_MATCH 계산 테스트(1등)")
    void testFirstPrize() {
        // given
        LottoDto firstPrize = new LottoDto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        lottoResult.calculateResults(Arrays.asList(firstPrize), winningNumbersDto);

        // then
        assertEquals(1, lottoResult.getPrizeCount().get(Prize.SIX_MATCH));
    }

    @Test
    @Order(2)
    @DisplayName("FIVE_WITH_BONUS 계산 테스트(2등)")
    void testSecondPrize() {
        // given
        LottoDto secondPrize = new LottoDto(Arrays.asList(1, 2, 3, 4, 5, 7));

        // when
        lottoResult.calculateResults(Arrays.asList(secondPrize), winningNumbersDto);

        // then
        assertEquals(1, lottoResult.getPrizeCount().get(Prize.FIVE_WITH_BONUS));
    }

    @Test
    @Order(3)
    @DisplayName("FIVE_MATCH 계산 테스트(3등)")
    void testThirdPrize() {
        // given
        LottoDto thirdPrize = new LottoDto(Arrays.asList(1, 2, 3, 4, 5, 41));

        // when
        lottoResult.calculateResults(Arrays.asList(thirdPrize), winningNumbersDto);

        // then
        assertEquals(1, lottoResult.getPrizeCount().get(Prize.FIVE_MATCH));
    }

    @Test
    @Order(4)
    @DisplayName("FOUR_MATCH 계산 테스트(4등)")
    void testFourthPrize() {
        // given
        LottoDto fourthPrize = new LottoDto(Arrays.asList(1, 2, 3, 4, 41, 42));

        // when
        lottoResult.calculateResults(Arrays.asList(fourthPrize), winningNumbersDto);

        // then
        assertEquals(1, lottoResult.getPrizeCount().get(Prize.FOUR_MATCH));
    }

    @Test
    @Order(5)
    @DisplayName("THREE_MATCH 계산 테스트(5등)")
    void testFifthPrize() {
        // given
        LottoDto fifthPrize = new LottoDto(Arrays.asList(1, 2, 3, 41, 42, 43));

        // when
        lottoResult.calculateResults(Arrays.asList(fifthPrize), winningNumbersDto);

        // then
        assertEquals(1, lottoResult.getPrizeCount().get(Prize.THREE_MATCH));
    }

    @Test
    @Order(6)
    @DisplayName("NONE 계산 테스트(6등)")
    void testNoPrize() {
        // given
        LottoDto noPrize = new LottoDto(Arrays.asList(7, 8, 9, 10, 11, 12));

        // when
        lottoResult.calculateResults(Arrays.asList(noPrize), winningNumbersDto);

        // then
        assertEquals(1, lottoResult.getPrizeCount().get(Prize.NONE));
    }
}

