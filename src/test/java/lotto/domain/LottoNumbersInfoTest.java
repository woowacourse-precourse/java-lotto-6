package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.dto.LottoNumbersInfo;
import lotto.message.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoNumbersInfoTest {
    @ParameterizedTest(name = "[{index}등 결과] - {argumentsWithNames}")
    @DisplayName("로또 결과 정보를 가져온다.")
    @MethodSource("provideLottoNumbersInfo")
    void calculateLottoResult(LottoNumbersInfo numbersInfo, Map<LottoResult, BigDecimal> expected) {
        assertEquals(numbersInfo.getResult(), expected);
    }

    private static Stream<Arguments> provideLottoNumbersInfo() {
        return Stream.of(
                Arguments.of(new LottoNumbersInfo(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7
                ), Map.of(
                        LottoResult.FIRST, BigDecimal.ONE,
                        LottoResult.SECOND, BigDecimal.ZERO,
                        LottoResult.THIRD, BigDecimal.ZERO,
                        LottoResult.FOURTH, BigDecimal.ZERO,
                        LottoResult.FIFTH, BigDecimal.ZERO,
                        LottoResult.NONE, BigDecimal.ZERO
                )),
                Arguments.of(new LottoNumbersInfo(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7
                ), Map.of(
                        LottoResult.FIRST, BigDecimal.ZERO,
                        LottoResult.SECOND, BigDecimal.ONE,
                        LottoResult.THIRD, BigDecimal.ZERO,
                        LottoResult.FOURTH, BigDecimal.ZERO,
                        LottoResult.FIFTH, BigDecimal.ZERO,
                        LottoResult.NONE, BigDecimal.ZERO
                )),
                Arguments.of(new LottoNumbersInfo(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7
                ), Map.of(
                        LottoResult.FIRST, BigDecimal.ZERO,
                        LottoResult.SECOND, BigDecimal.ZERO,
                        LottoResult.THIRD, BigDecimal.ONE,
                        LottoResult.FOURTH, BigDecimal.ZERO,
                        LottoResult.FIFTH, BigDecimal.ZERO,
                        LottoResult.NONE, BigDecimal.ZERO
                )),
                Arguments.of(new LottoNumbersInfo(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 9, 8))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7
                ), Map.of(
                        LottoResult.FIRST, BigDecimal.ZERO,
                        LottoResult.SECOND, BigDecimal.ZERO,
                        LottoResult.THIRD, BigDecimal.ZERO,
                        LottoResult.FOURTH, BigDecimal.ONE,
                        LottoResult.FIFTH, BigDecimal.ZERO,
                        LottoResult.NONE, BigDecimal.ZERO
                )),
                Arguments.of(new LottoNumbersInfo(
                        List.of(new Lotto(List.of(1, 2, 3, 10, 9, 8))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7
                ), Map.of(
                        LottoResult.FIRST, BigDecimal.ZERO,
                        LottoResult.SECOND, BigDecimal.ZERO,
                        LottoResult.THIRD, BigDecimal.ZERO,
                        LottoResult.FOURTH, BigDecimal.ZERO,
                        LottoResult.FIFTH, BigDecimal.ONE,
                        LottoResult.NONE, BigDecimal.ZERO
                )),
                Arguments.of(new LottoNumbersInfo(
                        List.of(new Lotto(List.of(1, 2, 11, 10, 9, 8))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7
                ), Map.of(
                        LottoResult.FIRST, BigDecimal.ZERO,
                        LottoResult.SECOND, BigDecimal.ZERO,
                        LottoResult.THIRD, BigDecimal.ZERO,
                        LottoResult.FOURTH, BigDecimal.ZERO,
                        LottoResult.FIFTH, BigDecimal.ZERO,
                        LottoResult.NONE, BigDecimal.ONE
                ))
        );
    }
}
