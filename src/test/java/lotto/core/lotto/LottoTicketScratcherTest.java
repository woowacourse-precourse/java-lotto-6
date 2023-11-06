package lotto.core.lotto;

import static lotto.core.enums.AmountEnum.MIN_VALUE;
import static lotto.core.enums.AmountEnum.ZERO_VALUE;
import static lotto.core.enums.WinningChartEnum.FIVE_AND_BONUS_MATCH;
import static lotto.core.enums.WinningChartEnum.FIVE_MATCH;
import static lotto.core.enums.WinningChartEnum.FOUR_MATCH;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketScratcherTest {
    private static final LottoTicketScratcher TICKET_SCRATCHER = new LottoTicketScratcher();
    private final static Integer NORMAL_AMOUNT = 8000;
    private final static List<Integer> LOTTO_NUMBER_FIVE_MATCH = Arrays.asList(1,2,3,4,5,15);
    private final static List<Integer> LOTTO_NUMBER_FOUR_MATCH = Arrays.asList(1,2,3,33,5,15);
    private final static List<Integer> WINNING_NUMBERS = Arrays.asList(1,2,3,32,5,4);
    private final static List<Integer> LOSING_NUMBERS = Arrays.asList(45,44,43,42,41,40);
    private final static LottoTicket lottoTicketWithFiveMatch =new LottoTicket(LOTTO_NUMBER_FIVE_MATCH);
    private final static LottoTicket lottoTicketWithFourMatch =new LottoTicket(LOTTO_NUMBER_FOUR_MATCH);
    private final static WinningNumbers winningNumbers = new WinningNumbers(new LottoTicket(WINNING_NUMBERS));
    private final static WinningNumbers losingNumbers = new WinningNumbers(new LottoTicket(LOSING_NUMBERS));
    private final static BonusNumber loseBonusNumber = new BonusNumber(23);
    private final static BonusNumber winBonusNumber = new BonusNumber(15);
    @DisplayName("금액을 입력하면 최소금액 단위로 나누어 갯수를 반환한다.")
    @Test
    void convertAmountToQuantity() {
        Integer quantity = TICKET_SCRATCHER.convertAmountToQuantity(NORMAL_AMOUNT);
        assertThat(quantity).isEqualTo(NORMAL_AMOUNT/ MIN_VALUE.getAmount());
    }
    @DisplayName("당첨번호와 보너스 일치여부 확인 후 WinnerLotto 를 반환한다 : 5개 당첨.")
    @Test
    void calculateWinnerWhenBonusFalse() {
        ScratchedLottoTicket scratchedLottoTicket = TICKET_SCRATCHER.scratchTicket(winningNumbers, loseBonusNumber,
                lottoTicketWithFiveMatch);
        Integer winningPoint = scratchedLottoTicket.getMatchCount();
        assertThat(winningPoint).isEqualTo(FIVE_MATCH.getMatchCount());
    }

    @DisplayName("당첨번호와 일치여부 확인 후 WinnerLotto 를 반환한다. : 5개 + 보너스 당첨")
    @Test
    void calculateWinnerWhenBonusTrue() {
        ScratchedLottoTicket scratchedLottoTicket = TICKET_SCRATCHER.scratchTicket(winningNumbers, winBonusNumber,
                lottoTicketWithFiveMatch);
        Integer winningPoint = scratchedLottoTicket.getMatchCount();
        assertThat(winningPoint).isEqualTo(FIVE_MATCH.getMatchCount());
    }

    @DisplayName("보너스가 true일 때, matchCount 가 5가 아니라면,   bonus = false")
    @Test
    void calculateWinnerWhenBonusTrueCount4() {
        ScratchedLottoTicket scratchedLottoTicket = TICKET_SCRATCHER.scratchTicket(winningNumbers, winBonusNumber,
                lottoTicketWithFourMatch);
        Integer winningPoint = scratchedLottoTicket.getMatchCount();
        assertThat(winningPoint).isEqualTo(FOUR_MATCH.getMatchCount());
    }
    @DisplayName("로또 개수만큼 반복하여 ScratchedLottoTicket 리스트를 만들고, lottoTicketResult 로 반환한다")
    @Test
    void calculateResult() {
        //given
        List<LottoTicket> lottoTickets = Arrays.asList(lottoTicketWithFiveMatch, lottoTicketWithFourMatch);
        ScratchedLottoTicketList scratchedLottoTicketList = TICKET_SCRATCHER.scratchAllTickets(winningNumbers, winBonusNumber, lottoTickets);

        //when
        List<ScratchedLottoTicket> scratchedLottoTickets = scratchedLottoTicketList.getScratchedLottoTickets();

        List<LottoTicket> findLottoTickets = scratchedLottoTickets.stream().map(ScratchedLottoTicket::getLottoTicket).toList();


        int fiveAndBonusMatchCount = (int)scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(FIVE_AND_BONUS_MATCH)).count();
        int findFourMatchCount = (int)scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(FOUR_MATCH)).count();
        Integer fiveMatchCount = scratchedLottoTicketList.getFiveAndBonusMatchCount();
        Integer fourMatchCount = scratchedLottoTicketList.getFourMatchCount();

        //then
        assertThat(findLottoTickets).contains(lottoTicketWithFourMatch);
        assertThat(findLottoTickets).contains(lottoTicketWithFourMatch);
        assertThat(fiveMatchCount).isEqualTo(fiveAndBonusMatchCount);
        assertThat(fourMatchCount).isEqualTo(findFourMatchCount);
        assertThat(fiveMatchCount).isEqualTo(1);
        assertThat(fourMatchCount).isEqualTo(1);
    }

    @DisplayName("로또 개수만큼 반복하여 ScratchedLottoTicket 리스트를 만들고, lottoTicketResult 로 반환한다")
    @Test
    void calculateResultLose() {
        //given
        List<LottoTicket> lottoTickets = Arrays.asList(lottoTicketWithFiveMatch, lottoTicketWithFourMatch);
        ScratchedLottoTicketList scratchedLottoTicketList = TICKET_SCRATCHER.scratchAllTickets(losingNumbers, loseBonusNumber, lottoTickets);

        //when
        List<ScratchedLottoTicket> scratchedLottoTickets = scratchedLottoTicketList.getScratchedLottoTickets();

        List<LottoTicket> findLottoTickets = scratchedLottoTickets.stream().map(ScratchedLottoTicket::getLottoTicket).toList();
        int findFiveAndBonusMatchCount = (int)scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(FIVE_AND_BONUS_MATCH)).count();
        int findFourMatchCount = (int)scratchedLottoTickets.stream()
                .filter(ticket -> ticket.getWinningChartEnum().equals(FOUR_MATCH)).count();
        Integer fiveAndBonusMatchCount = scratchedLottoTicketList.getFiveAndBonusMatchCount();
        Integer fourMatchCount = scratchedLottoTicketList.getFourMatchCount();

        //then
        assertThat(findLottoTickets).contains(lottoTicketWithFourMatch);
        assertThat(findLottoTickets).contains(lottoTicketWithFourMatch);
        assertThat(fiveAndBonusMatchCount).isEqualTo(findFiveAndBonusMatchCount);
        assertThat(fourMatchCount).isEqualTo(findFourMatchCount);
        assertThat(fiveAndBonusMatchCount).isEqualTo(ZERO_VALUE.getAmount());
        assertThat(fourMatchCount).isEqualTo(ZERO_VALUE.getAmount());
    }
}