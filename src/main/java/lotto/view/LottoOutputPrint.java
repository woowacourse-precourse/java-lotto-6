package lotto.view;

import lotto.model.vo.SeasonLottoResultVO;

import java.util.List;

public class LottoOutputPrint {

    public void printLottoPrice(int num){
        System.out.println(num + "개를 구매했습니다.");
    }
    public void printLottoYield(double yield){
        System.out.println("총 수익률은 " + String.format("%.2f",yield) + "%입니다.");
    }
    public void printStatistics(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public void autoLottoTickMaker
      (int pick, List<SeasonLottoResultVO> Tickets)
    {
        for(int i = 0; i < pick; i++){
            System.out.println(Tickets.get(i).getAutoLottoNumber());
        }
    }


}
