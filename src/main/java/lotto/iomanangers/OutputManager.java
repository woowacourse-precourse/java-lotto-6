package lotto.iomanangers;

import java.math.BigDecimal;
import java.util.List;
import lotto.lotto.LottoTicket;

public class OutputManager {
    public void printPurchaseAmountAsk(){
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void printCountAnnounce(Integer NumberOfPurchase){
        System.out.println(NumberOfPurchase + "개를 구매했습니다.");
    }

    public void printOneLottoTicket(LottoTicket lottoTicket){
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
    public void printWinningChart(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printRateOfReturn(BigDecimal rateOfReturn){
        System.out.println("총 수익률은 " + rateOfReturn + " 입니다.");
    }


}
