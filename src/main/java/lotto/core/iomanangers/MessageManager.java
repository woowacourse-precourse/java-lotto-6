package lotto.core.iomanangers;

import static lotto.core.enums.WinningChartEnum.FIVE_AND_BONUS_MATCH;
import static lotto.core.enums.WinningChartEnum.FIVE_MATCH;
import static lotto.core.enums.WinningChartEnum.FOUR_MATCH;
import static lotto.core.enums.WinningChartEnum.SIX_MATCH;
import static lotto.core.enums.WinningChartEnum.THREE_MATCH;

import java.math.BigDecimal;
import java.util.List;
import lotto.core.exception.LottoApplicationException;
import lotto.core.lotto.LottoTicket;
import lotto.core.lotto.ScratchedLottoTicketList;

public class MessageManager {

    private record findCount(Integer threeMatchCount, Integer fourMatchCount, Integer fiveMatchCount,
                             Integer fiveAndBonusMatchCount, Integer sixMatchCount) {
    }

    public void printOneLottoTicketAnnounce(LottoTicket lottoTicket) {
        List<Integer> lotto = lottoTicket.getNumbers();
        System.out.println(lotto);
    }

    private static findCount getFindCount(ScratchedLottoTicketList scratchedLottoTicketList) {
        Integer threeMatchCount = scratchedLottoTicketList.getThreeMatchCount();
        Integer fourMatchCount = scratchedLottoTicketList.getFourMatchCount();
        Integer fiveMatchCount = scratchedLottoTicketList.getFiveMatchCount();
        Integer fiveAndBonusMatchCount = scratchedLottoTicketList.getFiveAndBonusMatchCount();
        Integer sixMatchCount = scratchedLottoTicketList.getSixMatchCount();
        return new findCount(threeMatchCount, fourMatchCount, fiveMatchCount, fiveAndBonusMatchCount,
                sixMatchCount);
    }

    public String printOut(BigDecimal rateOfReturn) {
        return ("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public void printWinningNumberAsk() {
        ConsoleOutputManager.printOut("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberAsk() {
        ConsoleOutputManager.printOut("보너스 번호를 입력해 주세요.");
    }

    public void printWinningChartAnnounce() {
        ConsoleOutputManager.printOut("당첨 통계" + System.lineSeparator() + "---");
    }
    public void printPurchaseAmountAsk() {
        ConsoleOutputManager.printOut("구입 금액을 입력해 주세요.");
    }

    public void printQuantityAnnounce(Integer NumberOfPurchase) {
        ConsoleOutputManager.printOut(NumberOfPurchase + "개를 구매했습니다.");
    }
    public String printWinningChart(ScratchedLottoTicketList scratchedLottoTicketList) {
        MessageManager.findCount findCount = getFindCount(scratchedLottoTicketList);
        return (THREE_MATCH.getDescription() + " - " + findCount.threeMatchCount() + "개") + System.lineSeparator()
                + (FOUR_MATCH.getDescription() + " - " + findCount.fourMatchCount() + "개") + System.lineSeparator()
                + (FIVE_MATCH.getDescription() + " - " + findCount.fiveMatchCount() + "개") + System.lineSeparator()
                + (FIVE_AND_BONUS_MATCH.getDescription() + " - " + findCount.fiveAndBonusMatchCount() + "개")
                + System.lineSeparator()
                + (SIX_MATCH.getDescription() + " - " + findCount.sixMatchCount() + "개");
    }
}
