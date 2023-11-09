package lotto.core.iomanangers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.core.LottoSystem;
import lotto.core.calculator.Calculator;
import lotto.core.lotto.BonusNumber;
import lotto.core.lotto.LottoTicket;
import lotto.core.lotto.LottoTicketScratcher;
import lotto.core.lotto.ScratchedLottoTicketList;
import lotto.core.lotto.WinningNumbers;
import lotto.core.numbergenerator.NumberGenerator;
import lotto.core.numbergenerator.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MessageManagerTest {

    private final static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final static NumberGenerator numberGenerator = new NumberGenerator(randomNumberGenerator);
    private final static MessageManager consoleOutputManager = new MessageManager();
    private final static Calculator calculator = new Calculator();
    private final static lotto.core.lotto.LottoTicketScratcher LottoTicketScratcher = new LottoTicketScratcher();

    @Test
    void winningChartAndRateOfReturnMessage() {
        //if
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket winningNumber = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(lottoTicket);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        BonusNumber bonusNumber = new BonusNumber(7);
        LottoSystem lottoSystem = new LottoSystem(calculator, LottoTicketScratcher, numberGenerator,
                consoleOutputManager);
        ScratchedLottoTicketList scratchedLottoTicketList = lottoSystem.calculateWinningChart(lottoTickets,
                winningNumbers, bonusNumber);
        MessageManager messageManager = new MessageManager();
        calculator.calculate(scratchedLottoTicketList, 1000);

        //when
        String rateOfReturnMessage = messageManager.winningChartAndRateOfReturnMessage(scratchedLottoTicketList,
                calculator.getRateOfReturn());

        //then
        Assertions.assertThat(rateOfReturnMessage)
                .contains("3개 일치 (5,000원) - 0개", "4개 일치 (50,000원) - 0개", "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개", "6개 일치 (2,000,000,000원) - 1개", "총 수익률은 200000.0%입니다.");
    }
}