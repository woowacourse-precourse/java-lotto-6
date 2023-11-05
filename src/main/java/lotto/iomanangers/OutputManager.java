package lotto.iomanangers;

import static lotto.enums.WinningChartEnum.FIVE_AND_BONUS_MATCH;
import static lotto.enums.WinningChartEnum.FIVE_MATCH;
import static lotto.enums.WinningChartEnum.FOUR_MATCH;
import static lotto.enums.WinningChartEnum.SIX_MATCH;
import static lotto.enums.WinningChartEnum.THREE_MATCH;

import java.math.BigDecimal;
import java.util.List;
import lotto.enums.WinningChartEnum;
import lotto.lotto.LottoTicket;
import lotto.lotto.ScratchedLottoTicket;
import lotto.lotto.ScratchedLottoTicketList;

public class OutputManager {
    public void printPurchaseAmountAsk(){
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void printQuantityAnnounce(Integer NumberOfPurchase){
        System.out.println(NumberOfPurchase + "개를 구매했습니다.");
    }

    public void printOneLottoTicketAnnounce(LottoTicket lottoTicket){
        List<Integer> lotto = lottoTicket.numbers();
        System.out.println(lotto);
    }

    public void printWinningNumberAsk(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberAsk(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    //TODO:구현필
    public void printWinningChartAnnounce(ScratchedLottoTicketList scratchedLottoTicketList){
        System.out.println("당첨 통계");
        System.out.println("---");
        this.printWinningChart(scratchedLottoTicketList);
    }
    public  void printWinningChart(ScratchedLottoTicketList scratchedLottoTicketList){
        Integer threeMatchCount = scratchedLottoTicketList.getThreeMatchCount();
        Integer fourMatchCount = scratchedLottoTicketList.getFourMatchCount();
        Integer fiveMatchCount = scratchedLottoTicketList.getFiveMatchCount();
        Integer fiveAndBonusMatchCount = scratchedLottoTicketList.getFiveAndBonusMatchCount();
        Integer sixMatchCount = scratchedLottoTicketList.getSixMatchCount();

        System.out.println(THREE_MATCH.getDescription() +" - " + threeMatchCount +"개");
        System.out.println(FOUR_MATCH.getDescription() +" - " + fourMatchCount +"개");
        System.out.println(FIVE_MATCH.getDescription() +" - " + fiveMatchCount +"개");
        System.out.println(FIVE_AND_BONUS_MATCH.getDescription() +" - " + fiveAndBonusMatchCount +"개");
        System.out.println(SIX_MATCH.getDescription() +" - " + sixMatchCount +"개");
    }

    public void printRateOfReturn(BigDecimal rateOfReturn){
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }


}
