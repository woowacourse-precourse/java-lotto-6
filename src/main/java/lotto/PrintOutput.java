package lotto;

import java.text.DecimalFormat;
import java.util.List;

public class PrintOutput {

    public void printLottoPrice(int Num) {
        System.out.println(Num + "개를 구매했습니다.");
    }
    public void printLottoList(List<Integer> lotto) {
        System.out.println(lotto);
    }
    public void printResult(){
        System.out.println("\n당첨 통계\n---");
    }
    public void printWinningStatics(String detail, int MatchCount){
        System.out.println(detail + MatchCount+"개");
    }
    public void printRateOfReturn(double ROR){
        DecimalFormat dc = new DecimalFormat("###,###,###,###,###,##0.0");
        String FormatROR = dc.format(ROR);
        System.out.printf("총 수익률은 " + FormatROR + "%%입니다.");
    }
}

