package lotto.calculator;

import static lotto.enums.AmountEnum.MIN_VALUE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.enums.AmountEnum;
import lotto.lotto.Lotto;
import lotto.lotto.WinnerLotto;
import lotto.lotto.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final Calculator calculator = new Calculator();
    private final static Integer NORMAL_AMOUNT = 8000;
    private final static List<Integer> LOTTO_NUMBER = Arrays.asList(1,2,3,4,5,15);
    private final static List<Integer> WINNING_NUMBERS = Arrays.asList(1,2,3,32,21,5);
    private final static Lotto lotto =new Lotto(LOTTO_NUMBER);
    private final static WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBERS);
    private final static Integer WINNING_POINT = 4;
    @DisplayName("금액을 입력하면 최소금액 단위로 나누어 갯수를 반환한다.")
    @Test
    void convertAmountToQuantity() {
        Integer quantity = calculator.convertAmountToQuantity(NORMAL_AMOUNT);
        assertThat(quantity).isEqualTo(NORMAL_AMOUNT/ MIN_VALUE.getAmount());
    }
    @DisplayName("당첨번호와 일치여부 확인 후 일치한다면 WinnerLotto 를 반환한다.")
    @Test
    void calculateWinner() {
        WinnerLotto winnerLotto = calculator.calculateWinner(winningNumbers, lotto);
        Integer winningPoint = winnerLotto.WinningPoint();
        assertThat(winningPoint).isEqualTo(WINNING_POINT);
    }
}