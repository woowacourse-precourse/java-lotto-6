package lotto.iomanangers;

import java.util.List;
import lotto.lotto.LottoTicket;
import lotto.numbergenerator.NumberGenerator;
import org.junit.jupiter.api.Test;

class OutputManagerTest {

    @Test
    void printOneLottoTicket() {
        OutputManager outputManager = new OutputManager();
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> lottoNumbersFromConsole = numberGenerator.createWinningNumbersFromConsole("1,2,3,4,5,6");
        outputManager.printOneLottoTicketAnnounce(new LottoTicket(lottoNumbersFromConsole));

    }
}