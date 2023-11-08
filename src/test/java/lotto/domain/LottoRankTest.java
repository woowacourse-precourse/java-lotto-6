package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.dto.LottoNumberCompareResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @DisplayName("당첨 로또 번호와 보너스 번호 매칭 결과에 따른 로또 랭크 결과 일치 테스트")
    @ParameterizedTest
    @MethodSource("getLottoNumberCompareResults")
    void findLottoRank(List<LottoNumberCompareResult> compareResults, List<LottoRank> expectedRanks) {
        // Act & Assert
        List<LottoRank> lottoRanks = compareResults.stream().map(LottoRank::findLottoRank).toList();
        Assertions.assertIterableEquals(expectedRanks, lottoRanks);
    }

    private static Stream<Arguments> getLottoNumberCompareResults() {
        return Stream.of(
                Arguments.of(List.of(LottoNumberCompareResult.of(3, false)), List.of(LottoRank.FIFTH_PLACE)),
                Arguments.of(List.of(
                        LottoNumberCompareResult.of(4, false),
                        LottoNumberCompareResult.of(5, true)
                ), List.of(
                        LottoRank.FOURTH_PLACE,
                        LottoRank.SECOND_PLACE)
                )
        );
    }
}