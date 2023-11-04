package lotto.calculator;

import static lotto.enums.AmountEnum.MIN_VALUE;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.lotto.BonusNumber;
import lotto.lotto.LottoTicket;
import lotto.lotto.WinnerLottoTicket;
import lotto.lotto.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final Calculator calculator = new Calculator();
    private final static Integer NORMAL_AMOUNT = 8000;
    private final static List<Integer> LOTTO_NUMBER = Arrays.asList(1,2,3,4,5,15);
    private final static List<Integer> WINNING_NUMBERS = Arrays.asList(1,2,3,32,5,10);
    private final static LottoTicket lottoTicket =new LottoTicket(LOTTO_NUMBER);
    private final static WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBERS);
    private final static BonusNumber bonusNumber = new BonusNumber(23); //보너스넘버는 기존 담청번호와 겹치지 않아야함.
    private final static Integer WINNING_POINT = 4;
    @DisplayName("금액을 입력하면 최소금액 단위로 나누어 갯수를 반환한다.")
    @Test
    void convertAmountToQuantity() {
        Integer quantity = calculator.convertAmountToQuantity(NORMAL_AMOUNT);
        assertThat(quantity).isEqualTo(NORMAL_AMOUNT/ MIN_VALUE.getAmount());
    }
    @DisplayName("당첨번호와 일치여부 확인 후 WinnerLotto 를 반환한다.")
    @Test
    void calculateWinner() {
        WinnerLottoTicket winnerLottoTicket = calculator.calculateWinner(winningNumbers, bonusNumber, lottoTicket);
        Integer winningPoint = winnerLottoTicket.matchCount();
        assertThat(winningPoint).isEqualTo(WINNING_POINT);
    }
}