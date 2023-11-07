package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @DisplayName("입력한 금액으로 Money를 생성한다.")
    @ParameterizedTest
    @MethodSource("moneyInfo")
    void createMoneyTest(long money) {
        assertThat(new Money(money).getMoney()).isEqualTo(money);
    }

    static List<Arguments> moneyInfo() {
        return Arrays.asList(
                Arguments.of(2_000_000_000),
                Arguments.of(30_000_000),
                Arguments.of(1_500_000),
                Arguments.of(50_000),
                Arguments.of(5_000)
        );
    }

    @DisplayName("로또 구매 개수를 가져온다.")
    @ParameterizedTest
    @MethodSource("numberOfPurchaseInfo")
    void getNumberOfPurchaseTest(long buyAmount, long numberOfPurchase) {
        assertThat(new Money(buyAmount).getNumberOfPurchase()).isEqualTo(numberOfPurchase);
    }

    static List<Arguments> numberOfPurchaseInfo() {
        return Arrays.asList(
                Arguments.of(2_000_000_000, 2_000_000),
                Arguments.of(30_000_000, 30_000),
                Arguments.of(1_500_000, 1_500),
                Arguments.of(50_000, 50),
                Arguments.of(5_000, 5)
        );
    }

    @DisplayName("금액을 출력 포맷으로 가져온다.")
    @ParameterizedTest
    @MethodSource("moneyPrintFormatInfo")
    void getMoneyPrintFormatTest(long buyAmount, String moneyPrintFormat) {
        assertThat(new Money(buyAmount).getMoneyPrintFormat()).isEqualTo(moneyPrintFormat);
    }

    static List<Arguments> moneyPrintFormatInfo() {
        return Arrays.asList(
                Arguments.of(2_000_000_000, "2,000,000,000"),
                Arguments.of(30_000_000, "30,000,000"),
                Arguments.of(1_500_000, "1,500,000"),
                Arguments.of(50_000, "50,000"),
                Arguments.of(5_000, "5,000")
        );
    }

    @DisplayName("수익률을 백분율 단위로 가져온다.")
    @ParameterizedTest
    @MethodSource("returnRateInfo")
    void getReturnRateTest(long buyAmount, long totalPrize, double returnRate) {
        assertThat(new Money(buyAmount).getReturnRate(totalPrize)).isEqualTo(returnRate);
    }

    static List<Arguments> returnRateInfo() {
        return Arrays.asList(
                Arguments.of(1_000_000, 0, 0.0),
                Arguments.of(1_000_000, 100_000_000, 10000.0),
                Arguments.of(5_000_000, 100_000_000, 2000.0),
                Arguments.of(10_000_000, 100_000_000, 1000.0),
                Arguments.of(50_000_000, 100_000_000, 200.0),
                Arguments.of(100_000_000, 100_000_000, 100.0)
        );
    }
}