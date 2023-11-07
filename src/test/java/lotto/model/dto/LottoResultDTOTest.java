package lotto.model.dto;

import lotto.model.PrizeCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultDTOTest {
    @DisplayName("결과 DTO의 각각의 등수와 당첨 개수 확인")
    @ParameterizedTest(name = "{1}")
    @MethodSource("getMatchResultSource")
    void getMatchResult(EnumMap<PrizeCategory, Integer> matchResults, String expectedStatus, double expectedReturnRate) {
        // given
        LottoResultDTO lottoResultDTO = new LottoResultDTO(matchResults, expectedReturnRate);

        // when
        int threeMatchCount = lottoResultDTO.getMatchResult(PrizeCategory.THREE_MATCH);
        int fourMatchCount = lottoResultDTO.getMatchResult(PrizeCategory.FOUR_MATCH);
        int fiveMatchCount = lottoResultDTO.getMatchResult(PrizeCategory.FIVE_MATCH_NO_BONUS);
        int fiveMatchWithBonusCount = lottoResultDTO.getMatchResult(PrizeCategory.FIVE_MATCH_WITH_BONUS);
        int sixMatchCount = lottoResultDTO.getMatchResult(PrizeCategory.SIX_MATCH);

        // then
        assertAll(
                expectedStatus,
                () -> assertEquals(matchResults.get(PrizeCategory.THREE_MATCH), threeMatchCount),
                () -> assertEquals(matchResults.get(PrizeCategory.FOUR_MATCH), fourMatchCount),
                () -> assertEquals(matchResults.get(PrizeCategory.FIVE_MATCH_NO_BONUS), fiveMatchCount),
                () -> assertEquals(matchResults.get(PrizeCategory.FIVE_MATCH_WITH_BONUS), fiveMatchWithBonusCount),
                () -> assertEquals(matchResults.get(PrizeCategory.SIX_MATCH), sixMatchCount)
        );

    }

    @DisplayName("결과 DTO의 총 수익률 확인")
    @ParameterizedTest(name = "수익률 {2}% 확인")
    @MethodSource("getMatchResultSource")
    void getTotalReturnRate(EnumMap<PrizeCategory, Integer> matchResults, String expectedStatus, double expectedReturnRate) {
        // given
        LottoResultDTO lottoResultDTO = new LottoResultDTO(matchResults, expectedReturnRate);

        // when
        double totalReturnRate = lottoResultDTO.getTotalReturnRate();

        // then
        assertEquals(expectedReturnRate, totalReturnRate);
    }

    static Stream<Arguments> getMatchResultSource() {
        EnumMap<PrizeCategory, Integer> firstCase = new EnumMap<>(PrizeCategory.class);
        firstCase.put(PrizeCategory.THREE_MATCH, 2);
        firstCase.put(PrizeCategory.FOUR_MATCH, 1);
        firstCase.put(PrizeCategory.FIVE_MATCH_NO_BONUS, 0);
        firstCase.put(PrizeCategory.FIVE_MATCH_WITH_BONUS, 0);
        firstCase.put(PrizeCategory.SIX_MATCH, 0);

        EnumMap<PrizeCategory, Integer> secondCase = new EnumMap<>(PrizeCategory.class);
        secondCase.put(PrizeCategory.THREE_MATCH, 0);
        secondCase.put(PrizeCategory.FOUR_MATCH, 0);
        secondCase.put(PrizeCategory.FIVE_MATCH_NO_BONUS, 4);
        secondCase.put(PrizeCategory.FIVE_MATCH_WITH_BONUS, 5);
        secondCase.put(PrizeCategory.SIX_MATCH, 0);

        return Stream.of(
                Arguments.of(
                        firstCase,
                        "3개 일치: 2, 4개 일치: 1",
                        Math.round(((double) 15000 / 10000) * 100.0) / 100.0),
                Arguments.of(
                        secondCase,
                        "5개 일치: 4, 5개 일치, 보너스 일치: 5",
                        Math.round(((double) 156000000 / 10000) * 100.0) / 100.0)
        );
    }
}