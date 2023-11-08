package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Result;

public class outputView {

    public void printLotto(List<Lotto> lottos){
        System.out.println();
        System.out.println(lottos.size() +"개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public void outputWinningStatistics(Result result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public void outputReturn(double rateReturn) {
        System.out.print("총 수익률은 " + rateReturn + "%입니다.");
    }

    public void printError(String message){
        System.out.println("[ERROR]"+message);
    }

}
