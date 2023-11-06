package lotto.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.core.calculator.Calculator;
import lotto.core.iomanangers.OutputManager;
import lotto.core.lotto.BonusNumber;
import lotto.core.lotto.LottoTicket;
import lotto.core.lotto.LottoTicketScratcher;
import lotto.core.lotto.ScratchedLottoTicketList;
import lotto.core.lotto.WinningNumbers;
import lotto.core.numbergenerator.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSystemTest {
    private final static NumberGenerator numberGenerator = new NumberGenerator();
    private final static OutputManager outputManager = new OutputManager();
    private final static Calculator calculator = new Calculator();
    private final static LottoTicketScratcher LottoTicketScratcher = new LottoTicketScratcher();

    @DisplayName("8000원을 넣었을 때 8을 반환한다.")
    @Test
    void chooseAmount() {

        //given
        LottoSystem lottoSystem = new LottoSystem(calculator, LottoTicketScratcher, numberGenerator, outputManager);
        //when
        Integer amountToQuantity = lottoSystem.chooseAmount("8000");

        //then
        assertThat(amountToQuantity).isEqualTo(8);
    }

    @DisplayName("8개만큼의 로또를 발행한다.")
    @Test
    void saveLottoTickets() {

        //given
        LottoSystem lottoSystem = new LottoSystem(calculator, LottoTicketScratcher, numberGenerator, outputManager);

        //when
        List<LottoTicket> lottoTickets = lottoSystem.saveLottoTickets(8);

        //then
        assertThat(lottoTickets.size()).isEqualTo(8);
    }

    @DisplayName("콘솔에서 입력반은 문자열로 로또 번호를 반환한다.")
    @Test
    void chooseWinningNumber() {

        //given
        LottoSystem lottoSystem = new LottoSystem(calculator, LottoTicketScratcher, numberGenerator, outputManager);

        //when
        WinningNumbers winningNumbers = lottoSystem.chooseWinningNumber("1,2,3,4,5,6");

        //then
        assertThat(winningNumbers.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또티켓과, 당첨번호, 보너스번호를 비교하여 저장한다.")
    @Test
    void calculateWinningChart() {
        //given
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket winningNumber = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lottoTicket);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        BonusNumber bonusNumber = new BonusNumber(7);

        LottoSystem lottoSystem = new LottoSystem(calculator, LottoTicketScratcher, numberGenerator, outputManager);

        //when
        ScratchedLottoTicketList scratchedLottoTicketList = lottoSystem.calculateWinningChart(lottoTickets,
                winningNumbers, bonusNumber);

        //then
        assertThat(scratchedLottoTicketList.getSixMatchCount()).isEqualTo(1);
    }

    @DisplayName("최종 결과를 반환한다.")
    @Test
    void printRateOfReturn() {
        //given
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket winningNumber = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lottoTicket);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        BonusNumber bonusNumber = new BonusNumber(7);
        LottoSystem lottoSystem = new LottoSystem(calculator, LottoTicketScratcher, numberGenerator, outputManager);

        ScratchedLottoTicketList scratchedLottoTicketList = lottoSystem.calculateWinningChart(lottoTickets,
                winningNumbers, bonusNumber);

        //when
        String winningChart = lottoSystem.printWinningChart(1, scratchedLottoTicketList);

        //then
        assertThat(winningChart)
                .contains("3개 일치 (5,000원) - 0개", "4개 일치 (50,000원) - 0개", "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개", "6개 일치 (2,000,000,000원) - 1개", "총 수익률은 200000000.0%입니다.");
    }
}