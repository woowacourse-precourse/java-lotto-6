package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.dto.Payment;
import lotto.exception.LottoGameException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("결과값 계산 테스트")
    @Test
    public void testCalculateResult() throws LottoGameException {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Result result = calculator.calculateResult(lottos, winningNumbers, bonusNumber);

        Optional<Integer> firstRank = Optional.ofNullable(result.getRanks().get(1));

        firstRank.ifPresent(value -> {
            assertEquals(1, value.intValue());
        });
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    public void testCalculateIncomeRate() throws LottoGameException {
        Result result = new Result();
        result.addIncome(50000);

        Payment payment = Payment.create("10000");

        double incomeRate = calculator.calculateIncomeRate(result, payment);

        assertEquals(500.0, incomeRate, 0.01);
    }
}
