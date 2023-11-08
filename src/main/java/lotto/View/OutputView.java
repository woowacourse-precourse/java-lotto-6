package lotto.View;

import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.WinningDetails;

public class OutputView {

    public static void printLottoList(Integer count, List<Lotto> lottoList){
        System.out.println(count + "개를 구매했습니다.");
        String result="";
        for(int i=0; i<lottoList.size();i++){
            result+=lottoList.get(i).printLotto()+"\n";
        }
        System.out.println(result);
    }

    public static void printLottoResult(Double count, WinningDetails details){
        String result = details.getResult();
        System.out.println(result);
        System.out.println("총 수익률은 " + String.format("%.1f",Double.valueOf(details.calculatePrize()/(count*10)))+ "%입니다.");
    }
}
