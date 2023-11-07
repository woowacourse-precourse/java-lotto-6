package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import java.util.List;
import java.util.Set;

public class OutputView {

    public static void printRequestPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoQuantity(int quantity){
        System.out.println(quantity+"개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printRequestWinnerNumberMessage(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumberMessage(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResult(Result result){
        System.out.println("당첨 통계");
        System.out.println("---");
        Set<Rank> ranks = result.getResult().keySet();
        for(Rank rank : ranks){
            if(rank.getCount() > 0){
                System.out.println(rank.getMessage() + " - " + result.getResult().get(rank) + "개");
            }
        }
    }

    public static void printProfitRate(double profitRate){
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
