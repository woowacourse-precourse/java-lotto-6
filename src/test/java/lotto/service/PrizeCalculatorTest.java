package lotto.service;

import lotto.model.LottoPrize;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.Collections;
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

    static Stream<Arguments> totalReturnParametersProvider() {
        return Stream.of(
                Arguments.of(prizeCount(0, 0, 0, 0, 1), amountIs(3000), "166.7"),
                Arguments.of(prizeCount(0, 0, 0, 0, 0), amountIs(1000), "0.0"),
                Arguments.of(prizeCount(0, 0, 0, 0, 1), amountIs(5000), "100.0"),
                Arguments.of(prizeCount(0, 0, 0, 0, 1), amountIs(8000), "62.5"),
                Arguments.of(prizeCount(1, 0, 0, 0, 0), amountIs(5000), "40000000.0"),
                Arguments.of(prizeCount(0, 1, 1, 0, 0), amountIs(11000), "286363.6"),
                Arguments.of(prizeCount(0, 0, 0, 1, 1), amountIs(14000), "392.9"),
                Arguments.of(prizeCount(5, 0, 0, 0, 0), amountIs(5000), "200000000.0")
        );
    }

    static PurchaseAmount amountIs(Integer value) {
        return PurchaseAmount.of(value);
    }

    static List<LottoPrize> prizeCount(int first, int second, int third, int fourth, int fifth) {
        return Stream.of(
                        Collections.nCopies(first, FIRST_PLACE),
                        Collections.nCopies(second, SECOND_PLACE),
                        Collections.nCopies(third, THIRD_PLACE),
                        Collections.nCopies(fourth, FOURTH_PLACE),
                        Collections.nCopies(fifth, FIFTH_PLACE)
                )
                .flatMap(Collection::stream)
                .toList();
    }
}
