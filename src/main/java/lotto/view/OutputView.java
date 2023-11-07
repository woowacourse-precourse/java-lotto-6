package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoResultFormat;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    //발행된 로또 번호 출력
    public static void IssuedLottoNumbers(int amount, List<Lotto> lottos) {
        System.out.println("\n" + amount / 1000 + "개를 구입했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    //당첨 내역 출력
    public static void LottoResults(HashMap<LottoResultFormat, Integer> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for(LottoResultFormat key : lottoResults.keySet()){
            if(key != LottoResultFormat.FAIL){
                if(key == LottoResultFormat.FIVE_BONUS){
                    System.out.println(key.getLottoOfMatching() +"개 일치, 보너스 볼 일치 ("+key.getWinningAmount()+"원) - "+lottoResults.getOrDefault(key, 0)+"개");
                }
                System.out.println(key.getLottoOfMatching() +"개 일치 ("+key.getWinningAmount()+"원) - "+lottoResults.getOrDefault(key, 0)+"개");
            }
        }
    }

    //총 수익률 출력
    public static void totalReturnOnLotto(int returnOnLotto){
        System.out.println("총 수익률은 "+returnOnLotto+"%입니다.");
    }
}
