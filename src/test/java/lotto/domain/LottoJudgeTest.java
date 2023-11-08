package lotto.domain;

import lotto.domain.wrapper.BuyLottos;
import lotto.domain.wrapper.Lotto;
import lotto.domain.wrapper.WinLottoWithBonus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static lotto.handler.ConstantsHandler.DEFAULT_VALUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoJudgeTest {

    private static Stream<Arguments> checkLottoResultKeys() {
        return Stream.of(
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,4,5,6"))), LottoHandler.SIX),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,4,5,7"))), LottoHandler.FIVE_WITH_BONUS),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,4,5,8"))),  LottoHandler.FIVE),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,4,8,7"))),  LottoHandler.FOUR),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,9,8,7"))),  LottoHandler.THREE),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,10,9,8,7"))),  LottoHandler.OTHER)
        );
    }

    private static Stream<Arguments> checkLottoResultValues() {
        return Stream.of(
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,4,5,6"), Lotto.from("1,2,3,4,5,7"), Lotto.from("1,2,3,4,5,8"))), Map.of(
                        LottoHandler.SIX, 1,
                        LottoHandler.FIVE_WITH_BONUS, 1,
                        LottoHandler.FIVE, 1,
                        LottoHandler.FOUR, 0,
                        LottoHandler.THREE, 0,
                        LottoHandler.OTHER, 0
                )),
                Arguments.of(BuyLottos.create(List.of(Lotto.from("1,2,3,11,12,13"), Lotto.from("1,2,3,4,5,7"), Lotto.from("1,2,21,22,23,24"), Lotto.from("1,2,31,32,33,34"))), Map.of(
                        LottoHandler.SIX, 0,
                        LottoHandler.FIVE_WITH_BONUS, 1,
                        LottoHandler.FIVE, 0,
                        LottoHandler.FOUR, 0,
                        LottoHandler.THREE, 1,
                        LottoHandler.OTHER, 2
                ))
        );
    }

    private WinLottoWithBonus winLottoWithBonus;

    @BeforeEach
    void init() {
        winLottoWithBonus = WinLottoWithBonus.create(List.of(1, 2, 3, 4, 5, 6), "7");
    }

    @DisplayName("Result의 key 값인 Handler 객체가 정상적으로 반환된다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @MethodSource("checkLottoResultKeys")
    void checkKeys(BuyLottos buyLottos, LottoHandler result) {
        LottoJudge lottoJudge = LottoJudge.create(buyLottos, winLottoWithBonus);

        for (LottoHandler lottoHandler : lottoJudge.matchLottoHandler().keySet()) {
            assertThat(lottoHandler).isEqualTo(result);
        }
    }

    @DisplayName("Result의 value 값이 정상적으로 반환된다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @MethodSource("checkLottoResultValues")
    void checkValues(BuyLottos buyLottos, Map<LottoHandler, Integer> expectedResult) {
        LottoJudge lottoJudge = LottoJudge.create(buyLottos, winLottoWithBonus);
        Map<LottoHandler, Integer> actualResult = lottoJudge.matchLottoHandler();

        for (Map.Entry<LottoHandler, Integer> entry : expectedResult.entrySet()) {
            LottoHandler lottoHandler = entry.getKey();
            int expectedValue = entry.getValue();
            int actualValue = actualResult.getOrDefault(lottoHandler, DEFAULT_VALUE);

            assertThat(actualValue).isEqualTo(expectedValue);
        }
    }
}
