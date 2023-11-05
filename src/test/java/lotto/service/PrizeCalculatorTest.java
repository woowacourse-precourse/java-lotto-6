package lotto.service;

import lotto.model.LottoPrize;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.model.LottoPrize.FIFTH_PLACE;
import static lotto.model.LottoPrize.FIRST_PLACE;
import static lotto.model.LottoPrize.FOURTH_PLACE;
import static lotto.model.LottoPrize.SECOND_PLACE;
import static lotto.model.LottoPrize.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

class PrizeCalculatorTest {

    //TODO: 테스트를 위해서 이렇게 생성해도 될까?
    private final Calculator prizeCalculator = new PrizeCalculator();

    @DisplayName("로또 수익률 계산")
    @ParameterizedTest(name = "{displayName} prizes: {0}, expected: {1}")
    @MethodSource("totalReturnParametersProvider")
    void checkTotalReturn(List<LottoPrize> prizes, PurchaseAmount amount, String expected) {
        Long revenue = LottoPrize.sum(prizes);
        Long investmentCost = Long.valueOf(amount.getAmount());
        Double totalReturn = prizeCalculator.calculate(revenue, investmentCost);
        assertThat(String.format("%.1f", totalReturn * 100)).isEqualTo(expected);
    }

    static Stream<Arguments> totalReturnParametersProvider() { //TODO: 테스트 코드 파라미터가 좀 지저분함 0,0,1,0,1 이런식으로 표현?
        return Stream.of(
                Arguments.of(List.of(FIFTH_PLACE), PurchaseAmount.of(3000), "166.7"),
                Arguments.of(List.of(), PurchaseAmount.of(1000), "0.0"),
                Arguments.of(List.of(FIFTH_PLACE), PurchaseAmount.of(5000), "100.0"),
                Arguments.of(List.of(FIFTH_PLACE), PurchaseAmount.of(8000), "62.5"),
                Arguments.of(List.of(FIRST_PLACE), PurchaseAmount.of(5000), "40000000.0"),
                Arguments.of(List.of(THIRD_PLACE, SECOND_PLACE), PurchaseAmount.of(11000), "286363.6"),
                Arguments.of(List.of(FIFTH_PLACE, FOURTH_PLACE), PurchaseAmount.of(14000), "392.9"),
                Arguments.of(List.of(FIRST_PLACE, FIRST_PLACE, FIRST_PLACE, FIRST_PLACE, FIRST_PLACE),
                        PurchaseAmount.of(5000), "200000000.0")
        );
    }
}