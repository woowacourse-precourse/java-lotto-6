package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.argument.CalculateProfitArgumentsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class ProfitTest {

    @ParameterizedTest
    @ArgumentsSource(CalculateProfitArgumentsProvider.class)
    @DisplayName("총 수익률을 계산하는 기능 테스트")
    void calculateTest(final List<Integer> numbers, final int bonusNumber, final BigDecimal expected) {
        // give
        Money money = Money.from(8000);
        Lotteries lotteries = Lotteries.from(List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        ));
        Profit profit = Profit.from(money, lotteries);
        Lotto lotto = new Lotto(numbers);
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
        UserLotto userLotto = UserLotto.from(lotto, bonusLottoNumber);

        // when
        BigDecimal actual = profit.calculate(userLotto);

        // then
        assertEquals(expected, actual);
    }
}