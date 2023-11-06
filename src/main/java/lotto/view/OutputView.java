package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void purchaseLottoNumbersDisplay(List<Lotto> lottos){
        int lottoQuantity = lottos.size();

        System.out.println("");
        System.out.println(lottoQuantity+"개를 구매했습니다.");

        for (int quantity = 1 ; quantity <= lottoQuantity ; quantity++){
            lottos.get(quantity-1).lottoNumberDisplay();
        }

        System.out.println("");
    }

    public void lottoResultDisplay(Map<String,String> lottoWinningResult){
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoWinningResult.get("3개일치")+"개");
        System.out.println("4개 일치 (50,000원) - " + lottoWinningResult.get("4개일치")+"개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoWinningResult.get("5개일치")+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoWinningResult.get("5개일치_보너스일치")+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoWinningResult.get("6개일치")+"개");
        System.out.println("총 수익률은 "+  lottoWinningResult.get("총 수익률") +"%입니다.");
    }


}
