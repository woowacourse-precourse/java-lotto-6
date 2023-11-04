package lotto.calculator;

import static lotto.enums.AmountEnum.MIN_VALUE;
import static lotto.enums.WinningChartEnum.FIVE_MATCH;
import static lotto.enums.WinningChartEnum.FOUR_MATCH;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.lotto.BonusNumber;
import lotto.lotto.LottoTicket;
import lotto.lotto.LottoTicketResult;
import lotto.lotto.ScratchedLottoTicket;
import lotto.lotto.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final Calculator calculator = new Calculator();
    private final static Integer NORMAL_AMOUNT = 8000;
    private final static List<Integer> LOTTO_NUMBER_FIVE_MATCH = Arrays.asList(1,2,3,4,5,15);
    private final static List<Integer> LOTTO_NUMBER_FOUR_MATCH = Arrays.asList(1,2,3,33,5,15);
    private final static List<Integer> WINNING_NUMBERS = Arrays.asList(1,2,3,32,5,4);
    private final static LottoTicket lottoTicketWithFiveMatch =new LottoTicket(LOTTO_NUMBER_FIVE_MATCH);
    private final static LottoTicket lottoTicketWithFourMatch =new LottoTicket(LOTTO_NUMBER_FOUR_MATCH);
    private final static WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBERS);
    private final static BonusNumber loseBonusNumber = new BonusNumber(23); //보너스넘버는 기존 담청번호와 겹치지 않아야함.
    private final static BonusNumber winBonusNumber = new BonusNumber(15); //보너스넘버는 기존 담청번호와 겹치지 않아야함.
    @DisplayName("금액을 입력하면 최소금액 단위로 나누어 갯수를 반환한다.")
    @Test
    void convertAmountToQuantity() {
        Integer quantity = calculator.convertAmountToQuantity(NORMAL_AMOUNT);
        assertThat(quantity).isEqualTo(NORMAL_AMOUNT/ MIN_VALUE.getAmount());
    }
    @DisplayName("당첨번호와 보너스 일치여부 확인 후 WinnerLotto 를 반환한다 : 5개 당첨.")
    @Test
    void calculateWinnerWhenBonusFalse() {
        ScratchedLottoTicket scratchedLottoTicket = calculator.calculateWinner(winningNumbers, loseBonusNumber,
                lottoTicketWithFiveMatch);
        Integer winningPoint = scratchedLottoTicket.getMatchCount();
        assertThat(winningPoint).isEqualTo(FIVE_MATCH.getMatchCount());
    }

    @DisplayName("당첨번호와 일치여부 확인 후 WinnerLotto 를 반환한다. : 5개 + 보너스 당첨")
    @Test
    void calculateWinnerWhenBonusTrue() {
        ScratchedLottoTicket scratchedLottoTicket = calculator.calculateWinner(winningNumbers, winBonusNumber,
                lottoTicketWithFiveMatch);
        Integer winningPoint = scratchedLottoTicket.getMatchCount();
        assertThat(winningPoint).isEqualTo(FIVE_MATCH.getMatchCount());
    }

    @DisplayName("보너스가 true일 때, matchCount 가 5가 아니라면,   bonus = false")
    @Test
    void calculateWinnerWhenBonusTrueCount4() {
        ScratchedLottoTicket scratchedLottoTicket = calculator.calculateWinner(winningNumbers, winBonusNumber,
                lottoTicketWithFourMatch);
        Integer winningPoint = scratchedLottoTicket.getMatchCount();
        assertThat(winningPoint).isEqualTo(FOUR_MATCH.getMatchCount());
    }
    @DisplayName("로또 개수만큼 반복하여 ScratchedLottoTicket 리스트를 만들고, lottoTicketResult 로 반환한다")
    @Test
    void calculateResult() {
        //if
        List<LottoTicket> lottoTickets = Arrays.asList(lottoTicketWithFiveMatch, lottoTicketWithFourMatch);
        LottoTicketResult lottoTicketResult = calculator.calculateResult(winningNumbers, winBonusNumber, lottoTickets);

        //when
        List<ScratchedLottoTicket> scratchedLottoTickets = lottoTicketResult.getScratchedLottoTickets();

        List<LottoTicket> findLottoTickets = scratchedLottoTickets.stream().map(ScratchedLottoTicket::getLottoTicket).toList();
        int findFiveMatchCount = (int)scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(FIVE_MATCH)).count();
        int findFourMatchCount = (int)scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(FOUR_MATCH)).count();
        Integer fiveMatchCount = lottoTicketResult.getFiveMatchCount();
        Integer fourMatchCount = lottoTicketResult.getFourMatchCount();

        //then
        Assertions.assertThat(findLottoTickets).contains(lottoTicketWithFourMatch);
        Assertions.assertThat(findLottoTickets).contains(lottoTicketWithFourMatch);
        Assertions.assertThat(fiveMatchCount).isEqualTo(findFiveMatchCount);
        Assertions.assertThat(fourMatchCount).isEqualTo(findFourMatchCount);
    }
}